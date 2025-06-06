# Variables and Data Types

## Variables

Variables are names for a piece of memory given to data that we need to store and manipulate in our programs.They are used to temporarily store data in computer's memory.
Java is a strongly typed language i.e you need to specify the data type hold by variables.

When you *declare a variable*, you need to state the variable type along with giving it a name. Giving a variable a value is called *initializing a variable*. To initialize a variable, you just type the variable name followed by an equal sign, followed by the desired value.

```java
String zooName = "The Best Zoo";
```

`Identifiers`: An identifier is a name for something. The identifier’s meaning can change from one program to another, but some identifiers’ ­meanings tend to change more.

• Identifiers can be created by a Java programmer, you create new names for classes and other things that you describe in your programs. Of course,you may name something Prime, and the guy writing code two cubicles down the hall can name something else Prime. That’s okay because Java doesn’t have a predetermined meaning for Prime. In your program, you can make Prime stand for the Federal Reserve’s prime rate. And the guy down the hall can make Prime stand for the “bread, roll, preserves, and prime rib.” A conflict ­doesn’t arise, because you and your co-worker are writing two ­different Java programs.

• Identifiers from the API: The JCP members have created names for many things and thrown almost 40,000 of these names into the Java API. The API comes with each version of Java, so these names are available to anyone who writes a Java program. Examples of such names are String, Integer, JWindow, JButton, JTextField, and File.

Identifies tend to name variables,functions,arrays,classes e.t.c.

1. Variables name - It should be camelCase i.e myAge = 20;
2. Functions name - Should be camelcase i.e setColor();
3. Class & Interface names - It should be Pascal naming case i.e begin with capital letter. class Person{}
4. Constants names - They are all in capital.E.g String BANK = "KCB"

An identifier is the name of a variable, method, class, interface, or package. Luckily, the rules for identifiers for variables apply to all of the other types that you are free to name.
There are only four rules to remember for legal identifiers:

1. Identifiers must begin with a letter, a currency symbol, or a _symbol. Currency symbols include dollar ($), yuan (¥), euro (€), and so on.
2. Identifiers can include numbers but not start with them.
3. A single underscore _ is not allowed as an identifier.
4. You cannot use the same name as a Java reserved word. A reserved word is a special word that Java has held aside so that you are not allowed to use it. Remember that Java
is case sensitive, so you can use versions of the keywords that only differ in case.

`Initializing Variables`:-Before you can use a variable, it needs a value. Some types of variables get this value set automatically, and others require the programmer to specify it.

- Local Variables:- A local variable is variable defined within a constructor,method or initializer block.

```java
public int localVariable(){
   final int y = 10;//initialized variable
   int x;//uninitialized variable
}
```

Variables passed to a constructor or method is called *constructor parameter* or *method parameters* respectively.They are like local variables that has been pre-initialized.

```java
public void find(boolean check){}
```

- Instance variable(field):- Is a value defined within a specific instance of an object.Declared inside class but outside a method.
- class variable:- it is the one that is defined on the class level and shared among all instances of a class.It can be even be publicly accessible to classes outside the class and doesn't require instances to use.

NOTE:-Instance and class variables does not require you to initialize them.as soon as you declare these variables,they are given default value.The compiler doesn't know what value to use and so wants the simplest value it can give the type `null for object,zero for numeric types,false for boolean,char is NUL`.

`Inferring Type with var`:- You can use the keyword `var` instead of the type when declaring local variables under certain conditions.

```java
public class Zoo{
   public void whatAnimal(){
      var name = "Name";
      var size = 6;
   }
}
```

The formal name of this feature is *local variable type inference*.You can only use this feature for local variables.

Rules on scope include:

- Local variables: In scope from declarations to the end of the block.
- Method parameters: In scope for duration of the method.
- Instance variables: In scope from declaration until objects is eligible for garbage collections.
- class variables: In scope from declarations until the program ends.

## Data Types

Java types can split into two categories:-

1. Primitive types- for storing simple values.They are defined in Java Language.They are saved on Stack memory and values assigned to them using equal(=) operator.When declaring primitive types,we do not need to allocate memory.Memories are allocated and released by Java run time environments.
2. Reference types- for storing complex objects E.g date objects,mail messages.when declaring reference types,we should allocate the memory,Java run time automatically release the memory.

- **Primitive Types**:- They are grouped into 4 categories:

1. Boolean Type: They can only have one of two accepted values: `true or false`.Used in conditions.Default value is false.When field is of boolean,the getter for it has different syntax,are not prefixed with get but is.

2. The Char Type: Represents characters.Its values are 16-bit unsigned integers i.e UTF-16 code units.The representation of character is numeric i.e we can convert int values to char values.

3. Integer Primitives: Java defines six numeric types and each of them has specific internal representation on certain number of bits- minimum and maximum values.It includes bytes,int,short and long

4. Real primitives: Contains decimal point and decimal after it.two floating-point types are defined- float and double.

- byte(1 Byte)- [-128 - 127]
- short(2 Bytes) - [-32K - 32K]
- int(4 Bytes) - {-2B -2B}
- long(8 Bytes)
- float(4 Bytes)
- double(8 Bytes)
- char(2 Bytes)
- boolean(1 Byte)

```Java
byte age =21;
int viewsCount=10_000_000;
long views = 100_000_000_000L;
double price=10.99;
float discount = 10.99F;
char letter ='A';
boolean isEligable = false;
```

`literals`:- It is a synthetic representation of boolean,numeric,character or string data.It is a medium of expressing particular values in a program.

```java
int x = 100_000;//100_000 is a literal
```

- Integral literals - It can be specified in 4 ways:-
   1. Decimal literals(Base 10): Allowed digits are 0-9.
   2. Octal literals(Base 8): Allowed digits are 0-7.Should be prefixed with 0.
   3. Hexa-decimal literals(Base 16): Allowed digits are 0-9 and characters are a-f.We can use both uppercase and lowercase characters.
   4. Binary literals: Allowed digits are 0 and 1.Should be prefixed with 0b or 0B.

```java
int x = 101;//decimal literal
int x = 0146;//octal literal
int x = OX123Face//hexa-decimal literal
int x = 0b1111;//binary literal
```

- Floating-Point literal - We can specify literals in only decimal form.
      - decimal literals: Allowed digits are 0-9.

```java
double d = 123.333;
double d = 12e3;
```

- Char literals - can be specified in 4 ways:
   1. Single quote: Rep as a single character within single quote.
   2. Char literal as Integral literal: It will represent the Unicode value of the character,The integral literal xan be represented in Decimal,Octal and Hexadecimal forms.
   3. Unicode Representations: Can be represented in Unicode rep. '\uxxxx'.Here xxxx rep 4 hexadecimal numbers.
   4. Escape Sequence: Every escape sequence can be specified as char literals.

```java
char ch = 'a';
char ch = 062;
char ch ='\u0061';
char ch = '\n';
```

- Boolean literals - Only two values are allowed i.e true and false.

- **Reference Types**

```Java
Date date = new Date();
date.getTime();
```

- **new** keyword allocates memory.

- Reference type are copied by their reference while primitive are copied by their value hence independent.The primitive values are stored in different memory locations while the primitive values holds the memory address of object in memory.

## Type conversions and Casting

- `Type Casting`:-A data type is converted into another data type by the programmer using casting operator during program design.The destination data type may be smaller than source data type when converting the data type to another data type,that's why it's called *narrowing conversion*.If the number is bigger i.e from integer to byte;the value is divided by the maximum value in byte and remainder is given.

 `()` is a casting operator.

```java
destination_datatype = (target_datatype)variable;

byte x;
float y;

x = (byte)y;
```

- `Type conversion`:- A data type is automatically converted into another data type by compiler at compilation time.The destination type cannot be smaller than the source type,that's why it's called *widening conversion*.Can only be applied to compatible data types.Can be `byte > short > int > long >float> double`.

```java
byte x = 30;
int y;

y = x;
```

- `Type Promotion`: A small size of data type can be promoted to a large size of datatype.i.e a byte can be promoted to integer.It is done when any method which accepts a higher size data type argument is called with smaller data type.

```java
byte a =10;
byte b =100;

int result = a * b;
```

TODO Using wrapper classes for conversion.

```java

String y = "23";
int y = Integer.parseInt(y)
```

## Constants

```Java
final float PI =3.14F;
```

## Java Garbage Collections

Java provides a garbage collector to automatically look for objects that aren't needed anymore.Java code exists inside off a JVM,which includes numerous processes independent from your application code.One of the most important of those is a built-in garbage collector.

All java objects are stored in the program memory's heap.The heap,also referred as free store,represents a large pool of unused memory allocated to your java application.If your program keeps instantiating objects and leaving them on the heap, eventually it will run out of memory and crash.Garbage collection solves this problem.

`Garbage collection` refers to the process of automatically freeing memory on the heap by deleting objects that are no longer reachable in your program.There are many different algorithms for garbage collections

In Java and other languages, `eligible for garbage collection` refers to an object’s state of no longer being accessible in a program and therefore able to be garbage collected.
Java includes a built-­in method to help support garbage collection where you can suggest that garbage collection run.

```java
System.gc();
```

**Tracing Eligibility**:-The JVM waits patiently and monitors each object until it determines that the code no longer needs that memory. An object will remain on the heap until it is no longer reachable. An object is no longer reachable when one of two situations occurs:

1. The object no longer has any references pointing to it.
2. All references to the object have gone out of scope.
