# demo（Java 示例）

将原多子模块合并为**一个项目**（artifactId: java-demos），按**代码类型**分包，便于在一个工程里浏览和运行所有 Java 示例。

## 包结构（按类型）

| 包 | 说明 |
|----|------|
| **com.demo.basics** | 语言基础：泛型、SPI、序列化、Jackson、JNA 等 |
| **com.demo.apache.cxf** | Apache CXF Web 服务客户端 |
| **com.demo.bytecode** | 字节码（ASM）示例 |
| **com.demo.cache** | 缓存：Caffeine、Ehcache、Guava、Redis、Memcached |
| **com.demo.concurrency** | 并发：线程、线程池、原子类、锁等 |
| **com.demo.design** | 设计模式（含 pattern 子包） |
| **com.demo.function** | 函数式、Lambda、Stream |
| **com.demo.jvm** | JVM：类加载、GC 等 |
| **com.demo.rabbitmq** | RabbitMQ：helloworld、routing、subscribe、workqueue |
| **com.demo.reactor** | Project Reactor 响应式示例 |
| **com.demo.servlet** | Servlet、Filter、Listener 等 |
| **com.demo.zookeeper** | ZooKeeper：curator、raw API |

## 运行方式

- **普通 main**：在 IDE 中运行对应包下的 `Main` 或各示例类。
- **Servlet 示例**：本模块打包为 war，可部署到 Tomcat 等容器，或使用内嵌 Tomcat 运行。

## 编译与打包

在 **java/demo** 目录下执行：

```bash
mvn compile
# 打 war（含 Servlet 与 CXF 等）
mvn package
```

## 来源说明

由原 12 个子模块合并而来，包名与逻辑未改，仅合并为单模块（packaging war 以支持 servlet webapp）。
