# OPERATORS

A java `operator` is a special symbol that can be applied to a set of variables,values,or literals and that returns a result.`Operand` refers to the value or variable the operator is being applied to.The result of the operation is referred to as a `result`.

## Type of operators

Java supports three flavors of operators: unary, binary, and ternary. These types of operators can be applied to one, two, or three operands, respectively.

Operator Precedence:- In mathematics, certain operators can override other operators and be evaluated first. Determining which operators are evaluated in what order is referred to as `operator precedence`.The multiplication operator (*) has a higher precedence than the addition operator (+).The assignment operator (=) has the lowest order of precedence

Adding Parentheses - The order of operation changes explicitly by wrapping parentheses around the sections you want evaluated first.

- `Arithmetic Operators`:- Arithmetic operators are those that operate on numeric values.
   1. Addition a + b Adds two numeric values
   2. Subtraction c -­ d Subtracts two numeric values
   3. Multiplication e * f Multiplies two numeric values
   4. Division g / h Divides one numeric value by another
   5. Modulus i % j Returns the remainder after division of one numeric value by another

All of the arithmetic operators may be applied to any Java primitives, with the exception of boolean. Furthermore, only the addition operators + and += may be applied to String values, which results in String concatenation.”

- `Assignment Operator`:-An assignment operator is a binary operator that modifies, or assigns, the variable on the left side of the operator with the result of the value on the right side of the equation. Unlike most other Java operators, the assignment operator is evaluated from right to left.

Java will automatically promote from smaller to larger data types, as you saw in the previous section on arithmetic operators, but it will throw a compiler exception if it detects that you are trying to convert from larger to smaller data types without casting.

The simplest assignment operator is the = assignment

- `compound assignment operators.`:- Compound operators are really just glorified forms of the simple assignment operator, with a built-­in arithmetic or logical operation that applies the left and right sides of the statement and stores the resulting value in the variable on the left side of the statement.
   1. Addition assignment  a += 5  Adds the value on the right to the variable on the left and assigns the sum to the variable
   2. Subtraction assignment b -­= 0.2 Subtracts the value on the right from the variable on the left and assigns the difference to the variable
   3. Multiplication assignment c *= 100 Multiplies the value on the right with the variable on the left and assigns the product to the variable
   4. Division assignment d /= 4 Divides the variable on the left by the value on the right and assigns the quotient to the variable

- `Relational Operators`:- Relational operators compares two expressions and return a boolean value.
   1. Less than a < 5 Returns true if the value on the left is strictly less than the value on the right
   2. Less than or equal to b <= 6 Returns true if the value on the left is less than or equal to the value on the right
   3. Greater than c > 9 Returns true if the value on the left is strictly greater than the value on the right
   4. Greater than or equal to 3 >= d Returns true if the value on the left is greater than or equal to the value on the right
   5. Type comparison e instanceof String Returns true if the reference on the left side is an instance of the type on the right side (class, interface,record, enum, annotation)

- `Equality Operators`:- The equals operator (==) and not equals operator (!=) compare two operands and return a boolean value determining whether the expressions or values are equal or not equal, respectively.
   1. Equality a == 10 Returns true if the two values represent the same value.Returns true if the two values reference the same object.
   2. Inequality b != 3.14 Returns true if the two values represent different values.Returns true if the two values do  not reference the same object.

- `Logical Operators`:-The logical operators, (&), (|), and (^), may be applied to both numeric and boolean data types.When they’re applied to boolean data types, they’re
referred to as logical operators. Alternatively, when they’re applied to numeric data types,they’re referred to as bitwise operators, as they perform bitwise comparisons of the bits that compose the number.
   1. Logical AND a & b Value is true only if both values are true.
   2. Logical inclusive OR c | d Value is true if at least one of the values is true.
   3. Logical exclusive OR e ^ f Value is true only if one value is true and the other is false.(!)

- `Conditional Operators`:-The conditional operators, often called short-­circuit operators, are nearly identical to the logical operators, & and |, except that the right side of the expression may never be evaluated if the final result can be determined by the left side of the expression.
   1. Conditional AND a && b Value is true only if both values are true. If the left side is false, then the right side will not be evaluated.
   2. Conditional OR c || d Value is true if at least one of the values is true. If the left side is true, then the right side will not be evaluated.
For example, consider the following statement:

```java
int hour = 10;
boolean zooOpen = true || (hour < 4);
System.out.println(zooOpen); // true
```

A more common example of where conditional operators are used is checking for null objects before performing an operation. In the following example, if duck is null, the program
will throw a NullPointerException at runtime:

```java
if(duck!=null & duck.getAge()<5) { // Could throw a NullPointerException
// Do something
}
```

The issue is that the logical AND (&) operator evaluates both sides of the expression. We could add a second if statement, but this could get unwieldy if we have a lot of variables to check. An easy-­to-­read solution is to use the conditional AND operator (&&):

```java
if(duck!=null && duck.getAge()<5) {
// Do something
}
```

In this example, if duck is null, the conditional prevents a NullPointerException from ever being thrown, since the evaluation of duck.getAge() < 5 is never reached.

TODO increment and decrement operators.

`Making Decisions with the Ternary Operator`:-The conditional operator(? :), otherwise known as the ternary operator. It is notable in that it is the only operator
that takes three operands. The ternary operator has the following form:

booleanExpression ? expression1 : expression2

The first operand must be a boolean expression, and the second and third operands can be any expression that returns a value. The ternary operation is really a condensed form of a combined if and else statement that returns a value.
For example, consider the following code snippet that calculates the food amount for an owl:

```java
int owl = 5;
int food;
if(owl < 2) {
   food = 3;
} else {
   food = 4;
}
System.out.println(food);// 4
```

Compare the previous code snippet with the following ternary operator code snippet:

```java
int owl = 5;
int food = owl < 2 ? 3 : 4;
System.out.println(food); // 4
```
