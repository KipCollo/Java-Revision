# Lambda Expressions

A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.The main objective of Lambda expression is to get functional interface benefits.

Lambda expressions was introduce in 1930 and was big change in mathematics world.It was started to be used in programming kanguages.

Lambda expression is an anonymous function.

1. It doesn't have a name.
2. It doesn't have modifiers
3. No return type.

- Normal Functions

```java

public int sum(int a,int b){
    int result= a+b;
    return result;
}

public void fun(){
    System.out.Println("Lambda")
}

public int getLenth(int side){
    return side.length()
}
```

- Lambda Expression

```java
(int a,int b)->{int result = a+b}//(a,b)->int reult =a+b;(This is Type Inference i.e The data type is determined during Runtime)
()->{System.out.Println("Lambda")}//()->System.out.Println("Lambda")
(int side)->{return side.length()}//side->side.length()
```

## Characteristics

1. Lambda Expressions an take any no. of parameters.
2. If multiple parameters are present then it shuld be separated with comma.
3. If only one parameter is present then paranthesis are optional.
4. Type Inference- We do not need to pass data type in parameters,based on context compiler can detect the type automatically.
5. If Lambda method has one statement,then no need of curl braces
6. If Lambda returns something then we can remove return keyword.

Functinal Interfaces are used to call Lambda expressions even if has no name.
