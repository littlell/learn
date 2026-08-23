/*
 * InnoDB 死锁演示（MySQL 8.4，REPEATABLE-READ）
 *
 * 运行环境：Docker 容器 learn-mysql（端口 13306），由 AI 启动并在收尾时清理
 *
 * 准备两个终端（Terminal A / Terminal B），分别进入 mysql 客户端：
 *   docker exec -it learn-mysql mysql -uroot -proot learn
 *
 * 先整体执行本文件完成初始化（幂等，可重复执行）：
 *   docker exec -i learn-mysql mysql -uroot -proot learn < database/db_deadlock_innodb_lock_L2.sql
 *
 * 然后按文件底部注释的【步骤块】在两个终端交替粘贴执行。
 *
 * 核心结论：
 *   死锁 = 两个事务互相持有对方需要的锁，形成等待环
 *   InnoDB 通过 wait-for graph 环检测立刻发现死锁（不等超时），
 *   回滚 undo 量小的事务作为牺牲者，报 ERROR 1213 (40001)
 */

-- ============================================================
-- 第一部分：初始化（可整体执行，对交互无副作用）
-- ============================================================

SET GLOBAL innodb_print_all_deadlocks = ON;  -- 每次死锁都记录到错误日志

DROP TABLE IF EXISTS t_account;
CREATE TABLE t_account (
    id      INT PRIMARY KEY,
    name    VARCHAR(10),
    balance INT NOT NULL
) ENGINE=InnoDB;

INSERT INTO t_account VALUES (1, 'Alice', 100), (2, 'Bob', 100);

SELECT '初始化完成' AS '';
SELECT * FROM t_account;

-- ============================================================
-- 第二部分：观察查询模板（在死锁发生前/后按需执行）
-- ============================================================

-- 观察1：当前所有行锁（在 Terminal B 执行【步骤3】后、【步骤4】前运行，
--        能看到 A 的事务持有 GRANTED 锁、处于 WAITING 状态的锁请求）
SELECT ENGINE_TRANSACTION_ID, INDEX_NAME, LOCK_TYPE,
       LOCK_MODE, LOCK_STATUS, LOCK_DATA
FROM performance_schema.data_locks
WHERE OBJECT_NAME = 't_account';

-- 观察2：最近一次死锁现场（死锁发生后执行）
SHOW ENGINE INNODB STATUS;
-- 输出中找 LATEST DETECTED DEADLOCK 一节：
--   *** (1) TRANSACTION / HOLDS THE LOCK(S) / WAITING FOR
--   *** WE ROLL BACK TRANSACTION (x)  ← 牺牲者

-- 观察3：错误日志中的死锁记录（配合 innodb_print_all_deadlocks=ON）
-- docker exec learn-mysql bash -c 'grep -A20 "Deadlock" /var/lib/mysql/*.err 2>/dev/null || docker logs learn-mysql 2>&1 | grep -A20 "TRANSACTION"'

-- ============================================================
-- 第三部分：交互步骤（复制到终端手动执行，勿整文件跑）
-- ============================================================
--
-- 【场景一：转账交叉加锁 → 死锁】
--
-- Terminal A                          Terminal B
-- -----------                         -----------
-- 步骤1:                              步骤2:
--   BEGIN;                              BEGIN;
--   UPDATE t_account                    UPDATE t_account
--     SET balance=balance-10              SET balance=balance+10
--     WHERE id=1;                         WHERE id=2;
--   -- 成功，持有 id=1 的 X 锁          -- 成功，持有 id=2 的 X 锁
--
-- 步骤3（阻塞中）:                    （此时可在 B 执行"观察1"看锁状态）
--   UPDATE t_account
--     SET balance=balance+10
--     WHERE id=2;
--   -- 等 B 释放 id=2，一直卡住
--
--                                     步骤4:
--                                       UPDATE t_account
--                                         SET balance=balance-10
--                                         WHERE id=1;
--                                       -- 瞬间报错：
--                                       -- ERROR 1213 (40001): Deadlock found...
--                                       -- B 被选为牺牲者并回滚
--
-- 步骤5:                              步骤5':
--   -- A 的步骤3解除阻塞，正常返回       ROLLBACK;  -- 清理现场
--   COMMIT;
--
-- 步骤6: 在 A 或 B 执行"观察2"，阅读 LATEST DETECTED DEADLOCK 各字段
--
-- 【场景二：统一加锁顺序 → 不再死锁】（验证修复）
--
-- Terminal A                          Terminal B
-- -----------                         -----------
--   BEGIN;                              BEGIN;
--   UPDATE ... WHERE id=1;              UPDATE ... WHERE id=1;  -- B 在这里等
--   UPDATE ... WHERE id=2;              （等 A 提交后自动继续）
--   COMMIT;                             UPDATE ... WHERE id=2;
--                                       COMMIT;
--   -- 结果：无死锁，B 只是短暂等待。顺序一致 ⇒ 无环 ⇒ 无死锁
