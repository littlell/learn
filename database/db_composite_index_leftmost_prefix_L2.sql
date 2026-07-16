/*
 * 联合索引最左前缀原则演示（MySQL 8.0）
 *
 * 编译：无需编译
 * 运行：mysql -h127.0.0.1 -uroot -proot learn < database/db_composite_index_leftmost_prefix_L2.sql
 *
 * 核心结论：
 *   联合索引 (a, b, c) 相当于创建了 (a)、(a,b)、(a,b,c) 三个索引
 *   查询条件必须从最左列开始匹配，才能利用索引
 *   跳过中间列会导致后续列无法使用索引（但左前缀部分仍有效）
 */

-- 创建测试表
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    a    INT NOT NULL,
    b    INT NOT NULL,
    c    INT NOT NULL,
    d    VARCHAR(10)
) ENGINE=InnoDB;

-- 创建联合索引 (a, b, c)
ALTER TABLE t_user ADD INDEX idx_a_b_c (a, b, c);

-- 插入测试数据
INSERT INTO t_user (a, b, c, d) VALUES (1, 1, 1, 'r1');
INSERT INTO t_user (a, b, c, d) VALUES (1, 1, 2, 'r2');
INSERT INTO t_user (a, b, c, d) VALUES (1, 2, 1, 'r3');
INSERT INTO t_user (a, b, c, d) VALUES (1, 2, 2, 'r4');
INSERT INTO t_user (a, b, c, d) VALUES (2, 1, 1, 'r5');
INSERT INTO t_user (a, b, c, d) VALUES (2, 1, 2, 'r6');
INSERT INTO t_user (a, b, c, d) VALUES (2, 2, 1, 'r7');
INSERT INTO t_user (a, b, c, d) VALUES (2, 2, 2, 'r8');

SELECT '============================================' AS '';
SELECT '场景1：WHERE a=1 AND b=1 AND c=1 —— 全匹配' AS '';
EXPLAIN SELECT * FROM t_user WHERE a = 1 AND b = 1 AND c = 1;

SELECT '' AS '';
SELECT '场景2：WHERE a=1 AND b=1 —— 左两列' AS '';
EXPLAIN SELECT * FROM t_user WHERE a = 1 AND b = 1;

SELECT '' AS '';
SELECT '场景3：WHERE a=1 —— 仅最左列' AS '';
EXPLAIN SELECT * FROM t_user WHERE a = 1;

SELECT '' AS '';
SELECT '场景4：WHERE b=1 —— 跳过 a' AS '';
EXPLAIN SELECT * FROM t_user WHERE b = 1;

SELECT '' AS '';
SELECT '场景5：WHERE c=1 —— 跳过 a' AS '';
EXPLAIN SELECT * FROM t_user WHERE c = 1;

SELECT '' AS '';
SELECT '场景6：WHERE a=1 AND c=1 —— 跳过中间列 b' AS '';
EXPLAIN SELECT * FROM t_user WHERE a = 1 AND c = 1;

SELECT '' AS '';
SELECT '场景6（JSON）：查看 ICP（Index Condition Pushdown）' AS '';
EXPLAIN FORMAT=JSON SELECT * FROM t_user WHERE a = 1 AND c = 1;

SELECT '' AS '';
SELECT '场景7：WHERE a>1 AND b=1 —— a 范围查询' AS '';
EXPLAIN SELECT * FROM t_user WHERE a > 1 AND b = 1;

SELECT '' AS '';
SELECT '场景7（JSON）：查看范围导致后续列无法下推' AS '';
EXPLAIN FORMAT=JSON SELECT * FROM t_user WHERE a > 1 AND b = 1;

SELECT '' AS '';
SELECT '场景8：WHERE a=1 ORDER BY b —— 利用索引排序' AS '';
EXPLAIN SELECT * FROM t_user WHERE a = 1 ORDER BY b;
