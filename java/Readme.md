# Java

Java is an OOP language developed by Sun Microsystems.It was originally called Oak, developed by James Gosling.It was later purchased by Oracle.Originally designed for consumer electronics.

Java Editions includes:

1. Java Standard Edition - Java core platform.It lets you develop and deploy Java applications on desktops and servers. Java offers the rich user interface, performance, versatility, portability, and security that today's applications require.
2. Enterprise Edition - Used for building large scale and distributive systems.Built on top of java standard edition.It is the standard in community-driven enterprise software. Java EE is developed using the Java Community Process, with contributions from industry experts, commercial and open source organizations, Java User Groups, and countless individuals.
3. Java ME Micro Edition - Designed for mobile devices.
4. Java Card - Used in smart cards and sim cards.
5. Java MP Micro-profile - Used with microservices and allows you to define ,for a server,how your application should ne deployed and run as microservice.
6. Java Embedded - Oracle Java Embedded: Unlocking the Value of the Internet of Things with Intelligence on Devices
7. Java DB
8. Java TV

Here’s a brief history of modern computer programming:

✓ 1954–1957: FORTRAN is developed.

FORTRAN was the first modern computer programming language. For scientific programming, FORTRAN is a real racehorse. Year after year,FORTRAN is a leading language among computer programmers through-out the world.

✓ 1959: Grace Hopper at Remington Rand develops the COBOL ­programming language.

The letter B in COBOL stands for Business, and business is just what COBOL is all about. The language’s primary feature is the processing of one record after another, one customer after another, or one employee after another.Within a few years after its initial development, COBOL became the most widely used language for business data processing. Even today, COBOL represents a large part of the computer programming industry.

✓ 1972: Dennis Ritchie at AT&T Bell Labs develops the C programming language.

Code written in C uses curly braces, if statements, for statements, and so on.In terms of power, you can use C to solve the same problems that you can solve by using FORTRAN, Java, or any other modern programming language. (You can write a scientific calculator program in COBOL,but doing that sort of thing would feel really strange.) The difference between one programming language and another isn’t power. The difference is ease and appropriateness of use. That’s where the Java language excels.

✓ 1986: Bjarne Stroustrup (again at AT&T Bell Labs) develops C++.

Unlike its C language ancestor, the language C++ supports object-oriented programming. This support represents a huge step forward.

✓ May 23, 1995: Sun Microsystems releases its first official version of the Java programming language.

Java improves upon the concepts in C++. Java’s “Write Once, Run Anywhere” philosophy makes the language ideal for distributing code across the Internet.Additionally, Java is a great general-purpose programming language. With Java, you can write windowed applications, build and explore databases, control handheld devices, and more. Within five short years,the Java programming language had 2.5 million developers worldwide.

✓ 2002: Microsoft introduces a new language named C#.Many of the C# language features come directly from features in Java.

✓ 2007: Google adopts Java as the primary language for creating apps on Android mobile devices.

✓ January 2010: Oracle Corporation purchases Sun Microsystems, ­bringing Java technology into the Oracle family of products.

Additionally, Java technology provides interactive capabilities to all Blu-ray devices and is the most popular programming language in the TIOBE Programming Community Index on PYPL: the PopularitY of Programming Language Index, and on other indexes.

•1. What is the difference between JDK and JRE?
•2. Why is Java a platform independent language?
•3. What is the difference between an abstract class and an interface?
•4. What is the difference between final, finally, and finalize?
•5. What is the difference between stack and heap memory?
•6. What is the difference between method overloading and method overriding?
•7. What is the difference between an abstract class and an interface?
•8. What is the difference between a private and a protected modifier?
•9. What is constructor overloading in Java?
•10. What is the use of super keyword in Java?
•11. What is the difference between static methods, static variables, and static classes in Java?
•12. What exactly is System.out.println in Java?
•13. What part of memory - Stack or Heap - is cleaned in the garbage collection process?

## JDK8

1. JDK8 was created to simplify programming i.e way of writing code in less no. of lines.
2. It's also influenced by the hardware influence i.e CPU became multicore, majority of java programs used only one core.JDK8 enabled parallel programming/procesing so that Java programs can run in multi-processors.
3. Utilizes functional programming benefits into java. i.e we can pass code as method argument.

## Features in JDK8

1. Lamda Expression
2. Functional Interface
3. Defaut methods
4. Static methods
5. Method Reference Operator(::)
6. Stream API
7. Optional class
8. CompletableFuture, Asynchronous Programming
9. New Date & Time API.

Before writing Java program,you have to install JDK.There are two versions o JDKs:-

1. Proprietary JDK of Oracle.Every six months, Oracle releases a new version of Java.
2. JDK open version

## Java Development Kit(JDK)

The Java Development Kit (JDK) contains the minimum software you need to do Java development.JDK includes JRE,compiler(javac),an archiver(jar),interpreter/loader(java),documentation generator and other tools.

Key commands include:

1. javac: Converts .java source files into .class bytecode
2. java: Executes the program
3. jar: Packages files together
4. javadoc: Generates documentation

The javac program generates instructions in a special format called bytecode that the java command can run. Then java launches the Java Virtual Machine (JVM) before running the code. The JVM knows how to run bytecode on the actual machine it is on. You can think of the JVM as a special magic box on your machine that knows how to run your .class file within your particular operating system and hardware.

You'll need to add the JDK to the system variables.

To check if java is installed,you use the command:-

```bash
java --version
javac --version
```

TODO jshell

To enter into jshell prompt,use the command jshell in your shell:-

```bash
jshell

Picked up _JAVA_OPTIONS: -Dawt.useSystemAAFontSettings=on -Dswing.aatext=true
|  Welcome to JShell -- Version 21.0.4
|  For an introduction type: /help intro

jshell>
```

A Java program begins execution with its main() method.The main() method is often called an entry point into the program, because it is the starting point that the JVM looks for when it begins running a new program.

The main() method lets the JVM call our code.

```java
public static void main(String[] args) {
   System.out.println("Hello World");
}
```

The main() method’s parameter list, represented as an array of java.lang.String objects. You can use any valid variable name along with any of these three formats:

- String[] args
- String options[]
- String... friends

The compiler accepts any of these. The variable name args is common because it hints that this list contains values that were read in (arguments) when the JVM started. The characters [] are brackets and represent an array. An array is a fixed-­size list of items that are all of the same type. The characters ... are called varargs (variable argument lists).

To compile Java code with the javac command, the file must have the extension .java.The name of the file must match the name of the public class. The result is a file of bytecode with the same name but with a .class filename extension. Remember that bytecode consists of instructions that the JVM knows how to execute.

## Java Runtime Environment

Is an environment required to run Java applications.Includes JVM class libraries and other supporting files.It is updated regularly to kep up with security issues.Allows running of Jav apps without needing development tools.

## Java Virtual Machine

It is an abstract machine.It is a specification that provides runtime environment in which java bytecode can be executed.It is platform dependent.

Each Java Program only needs to be written and compiled once.A single compiled version of a program can only run on any platform.
