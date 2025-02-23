# Decision-Making Statements

Java operators allow you to create a lot of complex expressions, but they’re limited in the manner in which they can control program flow.

- Statements and Blocks:- a Java statement is a complete unit of execution in Java, terminated with a semicolon (;).Control flow statements break up the flow of execution by
using decision-­making, looping, and branching, allowing the application to selectively execute particular segments of code.A block of code in Java is a group of zero or more statements between balanced braces ({}) and can be used anywhere a single statement is allowed.

- Helps in controlling the flow of execution.
   1. Comparison operators
   2. Logical operators
   3. conditional statements
   4. loops

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

- The else Statement

Let’s expand our example a little. What if we want to display a different message if it is 11 a.m. or later? Can we do it using only the tools we have? Of course we can!

```java
if(hourOfDay < 11) {
   System.out.println("Good Morning");
}
if(hourOfDay >= 11) {
   System.out.println("Good Afternoon");
}
```

This seems a bit redundant, though, since we’re performing an evaluation on hourOfDay twice. Luckily, Java offers us a more useful approach in the form of an else statement.
Now our code is truly branching between one of the two possible options, with the boolean evaluation happening only once. The else operator takes a statement or block of
statements, in the same manner as the if statement. Similarly, we can append additional if statements to an else block to arrive at a more refined example:

```java
if(hourOfDay < 11) {
   System.out.println("Good Morning");
} else if(hourOfDay < 15) {
   System.out.println("Good Afternoon");
} else {
   System.out.println("Good Evening");
}
```

- *Pattern Matching*:-Java 16 officially introduced pattern matching with if statements and the instanceof operator.Pattern matching is a technique of controlling program flow that only executes a section of code that meets certain criteria. It is used in conjunction with if statements for greater program control.

- Switch

It is a multibranch statement that allows a variable to be tested for equality against a list of values.Each values is called a case, and the variable being switched on is checked for each switch case.It can be used with byte, char,short and int primitive data types.Can also be used with enumerated types, String class and few wrapper classes.

Switch Data Types- switch statement has a target variable that is not evaluated until runtime. The type of this target can include select primitive data types (int, byte, short, char)and their associated wrapper classes (Integer, Byte, Short, Character). The following is a list of all data types supported by switch statements:

1. int and Integer
2. short and Short
3. byte and Byte
4. char and Character
5. String
6. enum values
7. var (if the type resolves to one of the preceding types)

```Java
int value;// values can be strings,floats...

 switch(value){
    case value1:
      //statements
      break;

    case value2:
     //statements
     break;

    case value3:
     //statements
     break;

    default:
     // statement
 }
 ```

Break statements is necessary coz without them, statements in switch block fall through: all statements after matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.

- New Switch statement

```java
int value;// values can be strings,floats...

 switch(value){
    case value1 ->
     //statements

    case value2 ->
     //statements

    case value3->
     //statements

    default->
     // statement
 }
```

```java

int value=null;// values can be strings,floats...

 switch(value){
    case value1 -> value =1
    case value2 -> value =2
    case value3-> value=3
    default->value =4

 }

  system.out.println(value);
 ```

```java

int value=null;// values can be strings,floats...

 switch(value){
    case value1: yield value =1
    case value2: yield value =2
    case value3: yield value=3
    default: yield value =4

 }

  system.out.println(value);
```

## Loops

- `The for loop`:- A basic for loop has the same conditional boolean expression and statement as well as an initialization block and an update statement.Each of the three sections is separated by a semicolon. In addition, the initialization and update sections may contain multiple statements, separated by commas.

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

Alternatively, variables declared before the for loop and assigned a value in the initialization block may be used outside the for loop because their scope precedes the creation of the for loop.

```java
int i;
for(i=0; i < 10; i++)
System.out.println("Value is: "+i);
System.out.println(i);
```

**Working with for loops**:-

- Creating infinite loop-

```java
for( ; ; )
System.out.println("Hello World");
```

Although this for loop may look like it does not compile, it will in fact compile and run without issue. It is actually an infinite loop that will print the same statement repeatedly.This example reinforces the fact that the components of the for loop are each optional.Note that the semicolons separating the three sections are required, as for( ) without any semicolons will not compile.

- Adding Multiple Terms to the for Statement

```java
int x = 0;
for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
   System.out.print(y + " "); }
System.out.print(x + " ");
```

This code demonstrates three variations of the for loop you may not have seen.First, you can declare a variable, such as x in this example, before the loop begins and
use it after it completes. Second, your initialization block, boolean expression, and update statements can include extra variables that may or may not reference each other. For example, z is defined in the initialization block and is never used. Finally, the update statement can modify multiple variables.

- Redeclaring a Variable in the Initialization Block

```java
int x = 0;
for(int x = 4; x < 5; x++)// DOES NOT COMPILE
   System.out.print(x + " ");
```

This example looks similar to the previous one, but it does not compile because of the initialization block. The difference is that x is repeated in the initialization block after already being declared before the loop, resulting in the compiler stopping because of a duplicate variable declaration. We can fix this loop by removing the declaration of x from the for loop as follows:

```java
int x = 0;
for(x = 0; x < 5; x++)
System.out.print(x + " ");
```

Note that this variation will now compile because the initialization block simply assigns a value to x and does not declare it.

- Using Incompatible Data Types in the Initialization Block

```java
int x = 0;
for(long y = 0, int z = 4; x < 5; x++)// DOES NOT COMPILE
   System.out.print(y + " ");
```

This code will not compile, although this time for a different reason. The variables in the initialization block must all be of the same type. In the multiple-­terms example, y and z were both long, so the code compiled without issue; but in this example, they have different types, so the code will not compile.

- Using Loop Variables Outside the Loop

```java
for(long y = 0, x = 4; x < 5 && y < 10; x++, y++)
   System.out.print(y + " ");
System.out.print(x);// DOES NOT COMPILE
```

If you notice, x is defined in the initialization block of the loop and then used after the loop terminates. Since x was only scoped for the loop, using it outside the loop will cause a compiler error.

- `The for-­each Loop`:- The for-­each loop is a specialized structure designed to iterate over arrays and various ­Collections Framework classes

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

- `while Loops`:-The syntax is:

```java
while(logical expression){
   //statements
}
```
