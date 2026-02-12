#### Java8's support for functional style programming
> Lambda expressions

Lambda expressions are essentially anonymous functions.be one of the most significant additions to Java 8. 

> Default methods

In Java 8, we can add default and static methods to interfaces. This has a number
of advantages, including the ability to add capability to previous interfaces without
breaking the existing code. This has allowed interfaces declared prior to Java 8 to
be augmented with a default method that supports functional-type operations.

```bash
DefaultMethod
```

> FunctionalInterface

A functional interface is an interface that has one and only one abstract method, Functional interfaces facilitate the use of lambda expressions. 

```bash
FunctionalInterface
```

> Method and constructor references

A method or constructor reference is a technique that allows a Java 8 programmer
to use a method or constructor as if it was a lambda expression. 

```bash
MethodAndConstructorReference
```

> Collections

The Collection interface has been enhanced in Java with the addition of methods
that return a Stream object based on the collection. 

#### Functional programming concepts in Java

> High-order functions

A higher order function is a function that either takes a function (method) as parameter, or returns a function after its execution.

```bash
HighOrderFunctionParameter
HighOrderFunctionReturn
```

> First-class functions

Functions are treated like ordinary variables with a function type.

```bash
FirstClassFunction
```

> Closure in Java

 A closure is a function that uses the context within which it was defined. By context, we mean the variables within its scope. 
 
```bash
ClosureExample
```

> Currying

Some functions can have multiple arguments. It is possible to evaluate these arguments one-by-one. This process is called currying and normally involves creating new functions, which have one fewer arguments than the previous one.

```bash
CurryingExample
```

#### Functional interfaces

> Function

As its name implies, it performs a transformation type operation against its arguments.

```bash
FunctionType
```

> Predicate

The predicate-type interface is designed for use in situations where a test needs to be performed and a Boolean value needs to be returned.

```bash
PredicateType
```

> Consumer

The consumer-type functional interface is intended to accept input, but not return a value.

```bash
ConsumerType
```

> Supplier

The supplier-type functional interfaces are intended to return a data type, but no input is provided.

```bash
SupplierType
```

> Operator

The operator-type functional interfaces are used to apply some operation against one or two operands. It corresponds to unary or binary type operators.

```bash
OperatorType
```

#### Function Composition

By compose, we mean how they can be combined in interesting and powerful ways. These techniques include basic function composition and the use of fluent interfaces.

+ compose
+ andThen

```bash
FunctionComposition
```

#### Streams and the Evaluation of Expressions

A stream can be thought of as a sequence of elements processed by a series of methods using a fluent interface.

+ Creating streams
  + Fixed length streams
  + Infinite streams
+ Using the Stream class methods
  + Filter methods
  + Sorting streams
  + Mapping methods
    + map
    + reduce
  
```bash
StreamCreate
StreamFilter
StreamSort
StreamMap
```
#### Debugging lambda expressions

+ println
+ peek
+ IDE

```bash
LambdaDebug
```
