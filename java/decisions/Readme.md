# Decision-Making Statements

Java operators allow you to create a lot of complex expressions, but they’re limited in the manner in which they can control program flow.

- Statements and Blocks:- a Java statement is a complete unit of execution in Java, terminated with a semicolon (;).Control flow statements break up the flow of execution by
using decision-­making, looping, and branching, allowing the application to selectively execute particular segments of code.A block of code in Java is a group of zero or more statements between balanced braces ({}) and can be used anywhere a single statement is allowed.

## Conditional statements

- The if Statement

Often, we want to execute a block only under certain circumstances. The if statement accomplishes this by allowing our application to execute a particular block of code if and only if a boolean expression evaluates to true at runtime.

```java
if (booleanExpression){

}
```

```java
if(hourOfDay < 11)
   System.out.println("Good Morning");

if(hourOfDay < 11) {
   System.out.println("Good Morning");
   morningGreetingCount++;
}
```

NOTE:-

```java
if(hourOfDay < 11)
   System.out.println("Good Morning");
   morningGreetingCount++;
```

Based on the indentation, you might be inclined to think the variable morningGreetingCount is only going to be incremented if hourOfDay is less than 11,but that’s not what this code does. It will execute the print statement only if the condition is met, but it will always execute the increment operation.

Remember that in Java, unlike some other programming languages, tabs are just whitespace and are not evaluated as part of the execution. When you see a control flow
statement in a question, be sure to trace the open and close braces of the block, ignoring any indentation you may come across.

## Loops

- The for loop:- A basic for loop has the same conditional boolean expression and statement as well as an initialization block and an update statement.Each of the three sections is separated by a semicolon. In addition, the initialization and update sections may contain multiple statements, separated by commas.

Variables declared in the initialization block of a for loop have limited scope and are accessible only within the for loop.

It is entry-controlled loop and is used when action is to be repeated for a predetermined no. of times.

```java
for(initialization; booleanExpression; updateStatement){
   //body
}
```

```java
for(int i = 0; i < 5; i++) {
   System.out.print(i + " ");
}
```

- The for-­each Loop:- The for-­each loop is a specialized structure designed to iterate over arrays and various ­Collections Framework classes

```java
for(datatype instance: collection){
   //body
}
```

The for-­each loop declaration is composed of an initialization section and an object to be iterated over. The right side of the for-­each loop must be one of the following:

1. A built-­in Java array
2. An object whose type implements java.lang.Iterable

```java
public void printNames(String[] names) {
   for(int counter=0; counter<names.length; counter++)
      System.out.println(names[counter]);
}
public void printNames(String[] names) {
   for(var name : names)
      System.out.println(name);
}
```
