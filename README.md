# 技术学习训练场

本目录聚焦于**通过代码实践想法、加深概念理解**：写可运行的 Demo、做小实验、刷题、验证技术点。架构设计、思路梳理与绘图类内容在别处学习和沉淀，这里只做「能跑起来的代码」练习。

## 使用方式

- **按主题分类**：每个子目录对应一类技术关注点，便于按主题做 Demo、做 POC、巩固基础。
- **可随时扩展**：需要新分类时，在根目录下新增子目录即可，并可在本 README 中补充说明。
- **与工作解耦**：此处仅用于学习与实验，不依赖具体业务项目。

## 目录结构

| 目录 | 用途简述 |
|------|----------|
| [java](./java) | Java 核心与进阶：JVM、并发、设计模式、新特性等 |
| [backend](./backend) | 后端框架与微服务：Spring 生态、RPC、服务治理等 |
| [database](./database) | 数据库与存储：SQL、NoSQL、缓存、事务与调优 |
| [distributed](./distributed) | 分布式与中间件：消息队列、一致性、分布式事务等 |
| [network](./network) | 计算机网络：Socket、HTTP/TCP 行为、协议验证、抓包与解析等 |
| [cloud-native](./cloud-native) | 云原生与运维：Docker、K8s、CI/CD、可观测性 |
| [linux](./linux) | Linux：常用命令、Shell 脚本、进程与文件、文本处理与排查等 |
| [other-languages](./other-languages) | 其他语言学习：Go、Python、Rust 等，可按语言再分子目录 |
| [algorithms](./algorithms) | 算法与数据结构：刷题、经典实现、复杂度分析 |
| [books](./books) | 读书学习：按书名为子目录，通过源码跟读技术类书籍（含凤凰架构示例） |

## 已合并的原有学习内容

- **[java/lab](./java/lab)**：原 demo-java 多模块（并发、设计模式、JVM、字节码、缓存、Zookeeper、Reactor、Servlet、SPI、序列化、RabbitMQ 等）。
- **[backend/spring-boot](./backend/spring-boot)**：原 demo-spring-boot，已按业务主题拆分为 config、elasticsearch、rabbitmq、cassandra、mongodb、multicache、kafka、rsocket、resilience4j、errorhandling 等模块。
- **[backend/spring-core](./backend/spring-core)**：原 demo-spring-core，Spring Framework 核心多模块（core01～core23：IoC、Bean、XML 配置、生命周期、AOP、JdbcTemplate 等）。
- **[other-languages/python](./other-languages/python)**：原 demo-python（Python 基础与 NumPy、Jupyter 等）。
- **[algorithms/java](./algorithms/java)**：原 demo-java-algorithm，算法与数据结构 Java 实现。

## 后续可做的扩展

- 在某个子目录下再按主题或项目建二级目录（例如 `books/understanding-jvm`、`other-languages/go`）。
- 需要新的一级分类时，直接新建子目录并在本表中补一行说明即可。

---

*定位：仅做可通过代码实践的技术训练；架构设计、思路与绘图在别处沉淀。*
