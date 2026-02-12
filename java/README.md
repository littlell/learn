# Java 核心与进阶

放 Java 语言与运行时的学习与练习：JVM、并发、设计模式、新特性等。

**本目录现有内容：**

- **demo/**：独立 Maven 工程（与 backend 下 spring-core、spring-boot 一致），按类型分包。在 **java/demo** 目录下执行 `mvn compile` 可编译。
- 单文件练习（如 `SecuritySecureRandomObservation.java`）可直接放在本目录下。

可继续添加：JVM/GC 小实验、更多单文件 Demo、Java 新特性试用等。

---

## 模块与包结构说明（是否拆分过细）

### 当前情况

- **模块层面**：lab 下每个「主题」一个 Maven 模块（如 generics、spi、serialize、jackson 等）。其中部分主题**概念简单、类很少**，单独占一个模块会显得碎：
  - 如 **demo-java-spi**（约 4 个类）、**demo-java-jackson**（约 2 个类）、**demo-java-generics**（约 9 个类）、**demo-java-serialize**（约 9 个类）、**demo-java-log**、**demo-java-jna**、**demo-java-maven** 等，都属于「Java 语言/基础概念」类的小 Demo。
- **包层面**：各 demo 内部多为**一个主包 + 少量 bean/util 子包**，没有「一个简单概念一个包」的过度拆分；design-pattern 按模式分包（abstractfactory、singleton 等）是合理的，因为每个模式是一组协作类。

### 已做合并

**java** 下已合并为**单一模块** **demo**（artifactId: java-demos），按代码类型分包（包名不变，仅工程合并）：

- `com.demo.basics` — 泛型、SPI、序列化、Jackson、JNA 等
- `com.demo.apache.cxf`、**bytecode**、**cache**、**concurrency**、**design**、**function**、**jvm**、**rabbitmq**、**reactor**、**servlet**、**zookeeper**

原 12 个子模块已删除，仅保留 **demo**（packaging war，含 Servlet webapp）。运行方式见 `demo/README.md`。

---

## 其余样例代码是否有类似问题（整体结论）

对 **java**、**backend**、**algorithms**、**other-languages** 等目录扫过一遍后的结论如下。

### 1. java — 已合并为单模块

java 下仅保留 **demo**（java-demos）一个模块（按类型分包），与 backend 一样为「主题目录 + 子模块」结构。

### 2. backend/spring-core — 存在明显「按章节拆成多模块」的过细

- 当前：**23 个子模块**（demo-spring-core01 ～ demo-spring-core23），每个模块只有 2～7 个 Java 类，且多为「跟某一步/某章节」的一小段示例。
- 问题：和「Java 基本概念」合并前类似——**同一主题（Spring Core 学习）被拆成很多小 Maven 工程**，根目录模块过多。
- 建议：合并为**一个**模块 **demo-spring-core**，用**包**区分步骤，例如 `com.demo.spring.core.core01`、`core02`、…、`core23`，每个包内保留原有类与 `applicationContext.xml`（或统一放到 resources 下按编号）。这样 backend 下 spring-core 只占一个目录，结构更清晰。

### 3. backend/spring-boot — 无类似问题

- 每个子项目都是**完整可运行的 Spring Boot 应用**，且技术栈不同（Cassandra、Kafka、MongoDB、RabbitMQ、Resilience4j、RSocket 等），依赖与入口各异。
- **按应用/技术栈分模块是合理的**，不需要合并。

### 4. algorithms、other-languages — 无类似问题

- **algorithms**：只有一个 java 工程，下面按主题分包（linklist、queue、recurse、sort、stack），没有「一个概念一个 Maven 模块」。
- **other-languages/python**：`basic/`、`numpy/` 等按主题分目录，文件数量适中，结构清晰。

---

**已做重构（本次）**：

1. **java**：已合并为**单模块 demo**（artifactId: java-demos，与 backend 一致），按类型分包。
2. **backend/spring-core**：已合并为单模块并按功能子包（ioc、di、lifecycle、bean、annotation、javaconfig、spel、aop、tx），见 `backend/spring-core/README.md`。
