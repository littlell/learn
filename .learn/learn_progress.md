# Learn 进度追踪

| 日期 | 领域 | 主题 | 掌握程度 | 备注 |
|------|------|------|----------|------|
| 2026-06-24 | 工程实践 — JVM/GC | ZGC vs G1 停顿时间对比（ZGCPauseDemo） | 初识 | 跑通实验，原理还模糊；下次 JVM 轮转时优先重复 ZGC 读屏障/染色指针原理 |
| 2026-06-25 | 工程实践 — Spring | Spring AOP 代理机制：JDK vs CGLIB（AopProxyDemo） | 理解 | 能解释 JDK 动态代理与 CGLIB 的字节码原理差异及 Spring 选择策略 |
| 2026-07-16 | CS基础-L2 — 数据库原理 | 联合索引最左前缀原则 | 理解 | 能通过 EXPLAIN 分析 type/key_len/ref/Extra 判断索引使用情况，理解 ref/ALL/filesort/ICP 含义，对比 MySQL 5.7 vs 8.0 优化器差异 |
| 2026-08-23 | CS基础-L2 — 数据库原理 | InnoDB 死锁与加锁顺序 | 理解 | 能提炼「加锁顺序一致性 ⇔ 死锁」核心结论，理解循环等待条件、wait-for graph 环检测与牺牲者回滚；能区分死锁与普通阻塞；实验环境 MySQL 8.4 + performance_schema.data_locks |
