# Exceptions, Formatting Values & Localization

## Exceptions

Exception is an event that disrupts the normal flow of the program. It is an object which is thrown at runtime. The exception handling in java is one of the powerful mechanism to handle the runtime errors so that normal flow of the application can be maintained.

- An Error "indicates serious problems that a reasonable application should not try to catch."
- An Exception "indicates conditions that a reasonable application might want to catch."

- Types of Exceptions

1. `Checked Exception` - A checked exception is an exception that occurs at the compile time, these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, the programmer should take care of (handle) these exceptions. e.g. IOException, SQLException, ClassNotFoundException, CloneNotSupported, etc. Checked exceptions are checked at compile-time.
2. `Unchecked Exception` -An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are not checked at compile-time rather they are checked at runtime.
3. `Error` -These are not exceptions at all, but problems that arise beyond the control of the user or the programmer. Errors are typically ignored in your code because you can rarely do anything about an error. Suppose, if a stack overflow occurs, an error will arise. e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.

A program can fail for just about any reason. Here are just a few possibilities:

1. The code tries to connect to a website, but the Internet connection is down.
2. You made a coding mistake and tried to access an invalid index in an array.
3. One method calls another with a value that the method doesn’t support.

Java deals with exceptions either:-method can handle the exception case itself or make it the caller’s responsibility.

- Return Codes vs. Exceptions:- Exceptions are used when “something goes wrong.” However, the word wrong is subjective. The following code returns –1 instead of throwing an exception if no match is found:

```java
public int indexOf(String[] names, String name) {
   for (int i = 0; i < names.length; i++) {
      if (names[i].equals(name)) { return i; }
   }
   return -­1;
}
```

While common for certain tasks like searching, return codes should generally be avoided.After all, Java provided an exception framework, so you should use it!

An exception is an event that alters program flow. Java has a Throwable class for all objects that represent these events. Not all of them have the word exception in their class name,which can be confusing.

Categories of exception:-

java.lang.Throwable(checked)<--------java.lang.Exception(checked)<-------java.lang.RuntimeException(unchecked)
java.lang.Throwable(checked)<--------java.lang.Error(unchecked)

- A `checked exception` is an exception that must be declared or handled by the application code where it is thrown. In Java, checked exceptions all inherit Exception but not RuntimeException. Checked exceptions tend to be more anticipated—­for example, trying to read a file that doesn’t exist.

NOTE:- Checked exceptions also include any class that inherits Throwable but not Error or RuntimeException, such as a class that directly extends Throwable. For the exam, you just need to know about checked exceptions that extend Exception

Java has a rule called the handle or declare rule. The handle or declare rule means that all checked exceptions that could be thrown within a method are either wrapped in compatible try and catch blocks or declared in the method signature.Because checked exceptions tend to be anticipated, Java enforces the rule that the programmer must do something to show that the exception was thought about. Maybe it was handled in the method. Or maybe the method declares that it can’t handle the exception and someone else should.

Let’s take a look at an example. The following fall() method declares that it might throw an IOException, which is a checked exception:

```java
void fall(int distance) throws IOException {
if(distance > 10) {
 throw new IOException();
}
}
```

The throw keyword tells Java that you want to throw an Exception, while the throws keyword simply declares that the method might throw an Exception. It also might not.

- An `unchecked exception` is any exception that does not need to be declared or handled by the application code where it is thrown. Unchecked exceptions are often referred to as runtime exceptions, although in Java, unchecked exceptions include any class that inherits RuntimeException or Error.

NOTE:- t is permissible to handle or declare an unchecked exception. That said, it is better to document the unchecked exceptions callers should know about in a Javadoc comment rather than declaring an unchecked exception.

A runtime exception is defined as the RuntimeException class and its subclasses. Runtime exceptions tend to be unexpected but not necessarily fatal. For example, accessing an invalid array index is unexpected. Even though they do inherit the Exception class, they are not checked exceptions.
An unchecked exception can occur on nearly any line of code, as it is not required to be handled or declared. For example, a NullPointerException can be thrown in the body of the following method if the input reference is null:

```java
void fall(String input) {
System.out.println(input.toLowerCase());
}
```

We work with objects in Java so frequently that a NullPointerException can happen almost anywhere. If you had to declare unchecked exceptions everywhere, every single method would have that clutter! The code will compile if you declare an unchecked exception. However, it is redundant.

- `Error and Throwable`:- Error means something went so horribly wrong that your program should not attempt to recover from it. For example, the disk drive “disappeared” or the program ran out of memory.These are abnormal conditions that you aren’t likely to encounter and cannot recover from.While you can handle Throwable and Error exceptions, it is not recommended you do so in your application code.

- Java Exception Handling Keywords
  1. `try` -Java try block is used to enclose the code that might throw an exception. It must be used within the method. Java try block must be followed by either catch or finally block.
  2. `catch` -Java catch block is used to handle the Exception. It must be used after the try block only. You can use multiple catch block with a single try.
  3. `finally` -Java finally block is a block that is used to execute important code such as closing connection, stream etc. Java finally block is always executed whether exception is handled or not. Java finally block follows try or catch block.
  4. `throw` -Java throw keyword is used to explicitly throw an exception. We can throw either checked or uncheked exception in java by throw keyword. The throw keyword is mainly used to throw custom exception.
  5. `throws` -Java throws keyword is used to declare an exception. It gives an information to the programmer that there may occur an exception so it is better for the programmer to provide the exception handling code.

**NOTE :** Exception Handling is mainly used to handle the checked exceptions. If there occurs any unchecked exception such as NullPointerException, it is programmers fault that he is not performing check up before the code being used.

- `Printing an Exception`:- There are three ways to print an exception. You can let Java print it out, print just the message, or print where the stack trace comes from. This example shows all three approaches:

```java
public static void main(String[] args) {

   try {
      hop();
   } catch (Exception e) {
      System.out.println(e + "\n");
      System.out.println(e.getMessage()+ "\n");
      e.printStackTrace();
   }
}
private static void hop() {
   throw new RuntimeException("cannot hop");
}
```

This code prints the following:

```bash
java.lang.RuntimeException: cannot hop

cannot hop

java.lang.RuntimeException: cannot hop
 at Handling.hop(Handling.java:15)
 at Handling.main(Handling.java:7)
```

- `RuntimeException and its subclasses` are unchecked exceptions that don’t have to be handled or declared. They can be thrown by the programmer or the JVM. Common unchecked exception classes are
  1. ArithmeticException - Thrown when code attempts to divide by zero.
  2. ArrayIndexOutOfBoundsException - Thrown when code uses illegal index to access array.
  3. ClassCastException - Thrown when attempt is made to cast object to class of which it is not an instance.
  4. NullPointerException - Thrown when there is a null reference where an object is required.
  5. IllegalArgument­Exception - Thrown by programmer to indicate that method has been passed illegal or inappropriate argument.
  6. NumberFormatException - Subclass of IllegalArgumentException.Thrown when attempt is made to convert String to numeric type but String doesn’t have appropriate format.

- ArithmeticException

```java
int a = 50/0; //ArithmeticException
```

- NullPointerException

```java
String s = null;  
System.out.println(s.length());//NullPointerException
```

- NumberFormatException

```java
String s = "abc";  
int i = Integer.parseInt(s);//NumberFormatException  
```

- ArrayIndexOutOfBoundsException

```java
int a[] = new int[5];  
a[10] = 50; //ArrayIndexOutOfBoundsException  
```

- ClassCastException

```java
String type = "moose";
Object obj = type;
Integer number = (Integer) obj; // ClassCastException
```

- IllegalArgumentException:-IllegalArgumentException is a way for your program to protect itself. You want to tell the caller that something is wrong—­preferably in an obvious way that the caller can’t ignore so the programmer will fix the problem.

```java
setNumberEggs(-­2):

public void setNumberEggs(int numberEggs) {
   if (numberEggs < 0)
      throw new IllegalArgumentException("# eggs must not be negative");
   this.numberEggs = numberEggs;
}
```

- `Checked exceptions classes` have Exception in their hierarchy but not RuntimeException. They must be handled or declared. Common checked exceptions are:-
  1. FileNotFoundException - Subclass of IOException. Thrown programmatically when code tries to reference file that does not exist.
  2. IOException - Thrown programmatically when problem reading or writing file.
  3. NotSerializableException - Subclass of IOException. Thrown programmatically when attempting to serialize or deserialize non-­serializable class.
  4. ParseException - Indicates problem parsing input.
  5. SQLException - Thrown when error related to accessing database.

- `Error Classes`

- Errors:-
  1. Compile-time errors - Includes:- wrong syntax,forgetting semicolon.
  2. Runtime errors - Solved using a debugger.

- Errors are unchecked exceptions that extend the Error class. They are thrown by the JVM and should not be handled or declared. Errors are rare.
  1. ExceptionInInitializerError - Thrown when static initializer throws exception and doesn’t handle it
  2. StackOverflowError - Thrown when method calls itself too many times (called infinite recursion because method typically calls itself without end)
  3. NoClassDefFoundError - Thrown when class that code uses is available at compile time but not runtime

- `Using throws keyword`:- *Only **Checked exception** should be declared*, because **Unchecked Exception** are under your control (so correct your code) And **Errors** are beyond your control.
**Advantage :** By using throws keyword Checked Exception can be propagated (forwarded in call stack). It provides information to the caller of the method about the exception.
If you are calling a method that declares an exception, you must either caught or declare the exception.
  1. You caught the exception i.e. handle the exception using try/catch. - the code will be executed fine whether exception occurs during the program or not.
  2. You declare the exception i.e. specifying throws with the method. - if exception does not occur, the code will be executed fine.
- if exception occurs, an exception will be thrown at runtime because throws does not handle the exception.

You can rethrow and exception by throwing same exception in catch block.

- `Final` is used to apply restrictions on class, method and variable. Final class can't be inherited, final method can't be overridden and final variable value can't be changed.Final is a keyword.
- `Finally` is used to place important code, it will be executed whether exception is handled or not.Finally is a block.
- `Finalize` is used to perform clean up processing just before object is garbage collected.Finalize is a method.

- **Exception Handling with Method Overriding**

- If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.

- If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.

- *Java Custom Exception*:- If you are creating your own Exception that is known as custom exception or user-defined exception. Java custom exceptions are used to customize the exception according to user need.By the help of custom exception, you can have your own exception and message.

## Handling Exceptions

- *JVM's Default Exception Handler*:- The JVM firstly checks whether the exception is handled or not. If exception is not handled, JVM provides a default exception handler that performs the following tasks:
  1. Prints out exception description.
  2. Prints the stack trace (Hierarchy of methods where the exception occurred).
  3. Causes the program to terminate.

But if exception is handled by the application programmer, normal flow of the application is maintained i.e. rest of the code is executed.

- *Execution Propagation*:- An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to the previous method,If not caught there, the exception again drops down to the previous method, and so on until they are caught or until they reach the very bottom of the call stack.This is called exception propagation.
- By default Unchecked Exceptions are forwarded in calling chain (propagated).
- By default, Checked Exceptions are not forwarded in calling chain (propagated).

- `Using try and catch Statements`:- Java uses a try statement to separate the logic that might throw an exception from the logic to handle that exception
 Syntax:-

```java
try{
   //protected code
} catch(exception_type identifier){
   //Exception handler
}
```

The code in the try block is run normally. If any of the statements throws an exception that can be caught by the exception type listed in the catch block, the try block stops running, and execution goes to the catch statement. If none of the statements in the try block throws an exception that can be caught, the catch clause is not run.

- `Chaining catch Blocks`:- A rule exists for the order of the catch blocks. Java looks at them in the order they appear.If it is impossible for one of the catch blocks to be executed, a compiler error about unreachable code occurs. For example, this happens when a superclass catch block appears before a subclass catch block.
- If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
- All catch blocks must be ordered from most specific to most general i.e. catch for ArithmeticException must come before catch for Exception.

The following example shows exception types that do inherit from each other:

```java
public void visitMonkeys() {
   try {
      seeAnimal();
   } catch (ExhibitClosedForLunch e) { // Subclass exception
      System.out.print("try back later");
   } catch (ExhibitClosed e) {// Superclass exception
      System.out.print("not today");
   }
}
```

If the more specific ExhibitClosedForLunch exception is thrown, the first catch block runs. If not, Java checks whether the superclass ExhibitClosed exception is thrown and catches it. This time, the order of the catch blocks does matter. The reverse does not work.

```java
public void visitMonkeys() {
   try {
      seeAnimal();
   } catch (ExhibitClosed e) {
      System.out.print("not today");
   } catch (ExhibitClosedForLunch e) { // DOES NOT COMPILE
      System.out.print("try back later");
   }
}
```

If the more specific ExhibitClosedForLunch exception is thrown, the catch block for ExhibitClosed runs—­which means there is no way for the second catch block to ever run. Java correctly tells you there is an unreachable catch block.

- `Applying a Multi-­catch Block`:-A multi-­catch block allows multiple exception types to be caught by the same catch block.
 syntax:-

```java
try{
   //protected code
} catch (Exception1 | Exception2 e){
   //Exception handler
}

catch(Exception1 e | Exception2 e | Exception3 e) // DOES NOT COMPILE
catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE
catch(Exception1 | Exception2 | Exception3 e)
```

```java
public static void main(String args[]) {
   try {
      System.out.println(Integer.parseInt(args[1]));
   } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Missing or invalid input");
   } catch (NumberFormatException e) {
      System.out.println("Missing or invalid input");
   }
}
```

Notice that we have the same println() statement for two different catch blocks.We can handle this more gracefully using a multi-­catch block.

```java
public static void main(String[] args) {
   try {
      System.out.println(Integer.parseInt(args[1]));
   } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      System.out.println("Missing or invalid input");
   }
}
```

This is much better. There’s no duplicate code, the common logic is all in one place, and the logic is exactly where you would expect to find it. If you wanted, you could still have a second
catch block for Exception in case you want to handle other types of exceptions differently.

Java intends multi-­catch to be used for exceptions that aren’t related, and it prevents you from specifying redundant types in a multi-­catch.

```java
try {
 throw new IOException();
} catch (FileNotFoundException | IOException p) {} // DOES NOT COMPILE
```

Specifying related exceptions in the multi-­catch is redundant, and the compiler gives a message such as this:

```bash
The exception FileNotFoundException is already caught by the alternative IOException
```

Since FileNotFoundException is a subclass of IOException, this code will not compile. A multi-­catch block follows rules similar to chaining catch blocks together

- `finally Block`:-The try statement also lets you run code at the end with a finally clause, regardless of whether an exception is thrown.
- If you don't handle exception, before terminating the program, JVM executes finally block(if any).
- For each try block there can be zero or more catch blocks, but only one finally block.
- The finally block will not be executed if program exits(either by calling System.exit() or by causing a fatal error that causes the process to abort).

```java
try{
   //protected code
} catch(){
   //Exception handler
} finally {
   //finally block
}
```

**System.exit()**:- There is one exception to “the finally block will always be executed” rule: Java defines a method that you call as System.exit(). It takes an integer parameter that represents the status code that is returned.

```java
try {
 System.exit(0);
} finally {
 System.out.print("Never going to get here");// Not printed
}
```

System.exit() tells Java, “Stop. End the program right now. Do not pass Go. Do not collect $200.” When System.exit() is called in the try or catch block, the finally block does not run.

**Automating Resource Management**:Often, your application works with files, databases, and various connection objects. Commonly, these external data sources are referred to as resources. In many cases, you open a connection to the resource, whether it’s over the network or within a file system. You then read/write the data you want. Finally, you close the resource to indicate that you are
done with it.
What happens if you don’t close a resource when you are done with it? In short, a lot of bad things could happen. If you are connecting to a database, you could use up all available connections, meaning no one can talk to the database until you release your connections. Although you commonly hear about memory leaks causing programs to fail, a resource leak is just as bad and occurs when a program fails to release its connections to a resource, resulting in the resource becoming inaccessible. This could mean your program can no longer talk to the database—­or, even worse, all programs are unable to reach the database!
A resource is typically a file or database that requires some kind of stream or connection to read or write data.

- `Introducing Try-­with-­Resources`:- Java includes the try-­with-­resources statement to automatically close all resources opened in a try clause. This feature is also known as automatic resource
management, because Java automatically takes care of the closing.

```java
public void readFile(String file) {
FileInputStream is = null;
try {
   is = new FileInputStream("myfile.txt");
   // Read file data
} catch (IOException e) {
   e.printStackTrace();
} finally {
   if(is != null) {
      try {
         is.close();
      } catch (IOException e2) {
         e2.printStackTrace();
    }
   }
 }
}
```

```java
public void readFile(String file) {
   try (FileInputStream is = new FileInputStream("myfile.txt")) {
      // Read file data
   } catch (IOException e) {
      e.printStackTrace();
   }
}
```

Behind the scenes, the compiler replaces a try-­with-­resources block with a try and finally block. We refer to this “hidden” finally block as an implicit finally block since it is created
and used by the compiler automatically. You can still create a programmer-­defined finally block when using a try-­with-­resources statement; just be aware that the implicit one will be called first.

- `Basics of Try-­with-­Resources`:-When multiple resources are opened, they are closed in the reverse of the order in which they were created. Parentheses are used to list those resources, and semicolons are used to separate the declarations.

```java
try(var in = new FileInputStream("data.txt");
   var out = new FileOutputStream("output.txt");){
      //protected code
}catch (IOException e){
   //Exception handler
} finally{
   // finally block
}
```

A catch block is optional with a try-­with-­resources statement. For example, we can rewrite the previous readFile() example so that the method declares the exception to make it even shorter:

```java
public void readFile(String file) throws IOException {
   try (FileInputStream is = new FileInputStream("myfile.txt")) {
      // Read file data
   }
}
```

A try-­with-­resources statement differs from a try statement in that neither of catch block is required, although a developer may add both. Implicit finally block runs before any programmer-­coded ones.

- `Constructing Try-­with-­Resources Statements`:- Only classes that implement the AutoCloseable interface can be used in a try-­with-­resources statement. For example, the following does not compile as String does not implement the AutoCloseable interface:

```java
try (String reptile = "lizard") {}
```

Inheriting AutoCloseable requires implementing a compatible close() method.

```java
interface AutoCloseable {
public void close() throws Exception;
}
```

From method overriding,the implemented version of close() can choose to throw Exception or a subclass or not throw any exceptions at all.The following custom resource class that
simply prints a message when the close() method is called:

```java
public class MyFileClass implements AutoCloseable {
   private final int num;
   public MyFileClass(int num) { this.num = num; }
   @Override public void close() {
      System.out.println("Closing: " + num);
} }
```

NOTE:- You can encounter resources that implement Closeable rather than AutoCloseable. Since Closeable extends AutoCloseable, they are both supported in try-­with-­resources statements. The only difference between the two is that Closeable’s close() method declares IOException, while AutoCloseable’s close() method declares Exception.

- `Declaring Resources`:- While try-­with-­resources does support declaring multiple variables, each variable must be declared in a separate statement. For example, the following do not compile:

```java
try (MyFileClass is = new MyFileClass(1),// DOES NOT COMPILE
   os = new MyFileClass(2)) {
}
try (MyFileClass ab = new MyFileClass(1),// DOES NOT COMPILE
   MyFileClass cd = new MyFileClass(2)) {
}
```

The first example does not compile because it is missing the data type, and it uses a comma (,) instead of a semicolon (;). The second example does not compile because it also uses a comma (,) instead of a semicolon (;). Each resource must include the data type and be separated by a semicolon (;).
You can declare a resource using var as the data type in a try-­with-­resources statement, since resources are local variables.

```java
try (var f = new BufferedInputStream(new FileInputStream("it.txt"))) {
// Process file
}
```

Declaring resources is a common situation where using var is quite helpful, as it shortens the already long line of code.

- `Scope of Try-­with-­Resources`:- The resources created in the try clause are in scope only within the try block. This is another way to remember that the implicit finally runs before any catch/finally blocks that you code yourself. The implicit close has run already, and the resource is no longer available.

```java
try (Scanner s = new Scanner(System.in)) {
   s.nextLine();
} catch(Exception e) {
   s.nextInt(); // DOES NOT COMPILE
} finally {
   s.nextInt(); // DOES NOT COMPILE
}
```

- `Order of Operations`:- When working with try-­with-­resources statements, it is important to know that resources are closed in the reverse of the order in which they are created.

## Formatting Values

`- Formatting Numbers`:- Uses NumberFormat interface, which has two commonly used methods:

```java
public final String format(double number)
public final String format(long number)
```

Since NumberFormat is an interface, we need the concrete DecimalFormat class to use it. It includes a constructor that takes a pattern String:

```java
public DecimalFormat(String pattern)
```

- DecimalFormat symbols:-
  1. #- Omit position if no digit exists for it. - $2.2
  2. 0- Put 0 in position if no digit exists for it. - $002.20

```java
double d = 1234.567;
NumberFormat f1 = new DecimalFormat("###,###,###.0");
System.out.println(f1.format(d)); // 1,234.6

NumberFormat f2 = new DecimalFormat("000,000,000.00000");
System.out.println(f2.format(d)); // 000,001,234.56700

NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
System.out.println(f3.format(d)); // Your Balance $1,234.57
```

- `Formatting Dates and Times`:-The date and time classes support many methods to get data out of them.Java provides a class called DateTimeFormatter to display standard formats.

```java
LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
LocalTime time = LocalTime.of(11, 12, 34);
LocalDateTime dt = LocalDateTime.of(date, time);

System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));//2022-­10-­20
System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));//11:12:34
System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));//11:12:34 2022-­10-­20T11:12:34
```

The DateTimeFormatter will throw an exception if it encounters an incompatible type.
For example, each of the following will produce an exception at runtime since it attempts to format a date with a time value, and vice versa:

```java
date.format(DateTimeFormatter.ISO_LOCAL_TIME);// RuntimeException
time.format(DateTimeFormatter.ISO_LOCAL_DATE);// RuntimeException
```

Customizing the Date/Time Format - If you don’t want to use one of the predefined formats, DateTimeFormatter supports a custom format using a date format String.

```java
var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
System.out.println(dt.format(f)); // October 20, 2022 at 11:12
```

M is used for month, while y is used for year. And case matters! Using m instead of M means it will return the minute of the hour, not the month of the year.
The number often dictates the format of the date/time part. Using M by itself outputs the minimum number of characters for a month, such as 1 for January, while using MM always outputs two digits, such as 01. Furthermore, using MMM prints the three-­letter abbreviation, such as Jul for July, while MMMM prints the full month name.

Standard Date/Time Symbols:-

1. y - Year - 22, 2022
2. M - Month - 1, 01, Jan, January
3. d - Day - 5, 05
4. h - Hour - 9, 09
5. m - Minute - 45
6. S - Second - 52
7. a - a.m./p.m. - AM, PM
8. z - Time zone name - Eastern Standard Time, EST
9. Z - Time zone offset - -­0400

```java
var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);

var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
System.out.println(dt.format(formatter1)); // 10/20/2022 06:15:30

var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-­_dd");
System.out.println(dt.format(formatter2)); // 10_2022_-­_20

var formatter3 = DateTimeFormatter.ofPattern("h:mm z");
System.out.println(dt.format(formatter3)); // DateTimeException
```

- `Selecting a format() Method`:-The date/time classes contain a format() method that will take a formatter, while the formatter classes contain a format() method that will take a date/time value.

```java
var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");

System.out.println(dateTime.format(formatter));// 10/20/2022 06:15:30
System.out.println(formatter.format(dateTime));// 10/20/2022 06:15:30
```

These statements print the same value at runtime. Which syntax you use is up to you.

- `Adding Custom Text Values`:- One way to address this would be to break the formatter into multiple smaller formatters and then concatenate the results.

```java
var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);

var f1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy ");
var f2 = DateTimeFormatter.ofPattern(" hh:mm");
System.out.println(dt.format(f1) + "at" + dt.format(f2));//This prints October 20, 2022 at 06:15 at runtime.

```

- ou can escape the text by surrounding it with a pair of single quotes ('). Escaping text instructs the formatter to ignore the values inside the single quotes and just insert them as part of the final value.

```java
var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
System.out.println(dt.format(f)); // October 20, 2022 at 06:15'
```

- Java supports this by putting two single quotes next to each other.

```java
var g1 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
System.out.println(dt.format(g1)); // October 20, Party's at 06:15
var g2 = DateTimeFormatter.ofPattern("'System format, hh:mm: 'hh:mm");
System.out.println(dt.format(g2)); // System format, hh:mm: 06:15
var g3 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
System.out.println(dt.format(g3)); // NEW! 2022, yay!
```

If you don’t escape the text values with single quotes, an exception will be thrown at runtime if the text cannot be interpreted as a date/time symbol.

```java
DateTimeFormatter.ofPattern("The time is hh:mm");// Exception thrown
```
