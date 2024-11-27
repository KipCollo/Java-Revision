# Functional interfaces

Functional interfaces is an interface with single abstract method(SAM).It is used to invoke Lambda Expressions.

It can have default methods and static methods.

Example

```java
public interface Demo{
    public void fun();//abstract method
    default void fun1(){
        //body of default method
    };
    public static void fun2(){
        //body of static
    };
}
```

```java
public interface Demo1{
    public void fun();
    public void fun1();
}
```

Demo is functional interface coz it has one abstract method while Demo1 is not.

@FunctionalInterface annotation is used to indicate that the interface is functional interface.It helps in detection of more than one abstract method.It gives error incase of zero or more than one abstract method.

```java
@FunctionalInterface
public interface Demo{
    public void fun();
}
```

Runnable--run()-One abstract method
Callable--call()
Comparable--compareTo()
ActionListener--actionPerformed()

UseCase:

- If any interface extends Functional Interface andd child interface does not contain abstract methods then the child is also an Functional Interface.

```java
@FunctionalInterface
public interface Demo{
    public void fun();
}
```

```java
public interface Demo1 extends Demo{//valid Functional interface but not necessarily FI.

}
```

```java
public interface Demo2 extends Demo{
 public void fun1();//Not Functional interface
}
```

```java
@FunctionalInterface
public interface Demo3 extends Demo{//Functional interface

}
```

There is no implementation class for Functional interface.i.e replace implementation class with lambda expressions.
