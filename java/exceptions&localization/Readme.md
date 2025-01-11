# Exceptions

Exceptions
Types of Exceptions
Handling Exceptions
Custom Exceptions
Chaining Exceptions

A program can fail for just about any reason. Here are just a few possibilities:

1. The code tries to connect to a website, but the Internet connection is down.
2. You made a coding mistake and tried to access an invalid index in an array.
3. One method calls another with a value that the method doesn’t support.

A method can handle the exception case itself or make it the caller’s responsibility.

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

## Checked Exceptions

A checked exception is an exception that must be declared or handled by the application code where it is thrown. In Java, checked exceptions all inherit Exception but not
RuntimeException. Checked exceptions tend to be more anticipated—­for example, trying to read a file that doesn’t exist.

NOTE:- Checked exceptions also include any class that inherits Throwable but not Error or RuntimeException, such as a class that directly extends Throwable. For the exam, you just need to know about checked exceptions that extend Exception

Java has a rule called the handle or declare rule. The handle or declare rule means that all checked exceptions that could be thrown within a method are either wrapped in compatible try and catch blocks or declared in the method signature.

Because checked exceptions tend to be anticipated, Java enforces the rule that the programmer must do something to show that the exception was thought about. Maybe it was
handled in the method. Or maybe the method declares that it can’t handle the exception and someone else should.

Let’s take a look at an example. The following fall() method declares that it might throw an IOException, which is a checked exception:

```java
void fall(int distance) throws IOException {
if(distance > 10) {
throw new IOException();
}
}
```

The throw keyword tells Java that you want to throw an Exception, while the throws keyword simply declares that the method might throw an Exception. It also might not.

## Unchecked Exceptions

An unchecked exception is any exception that does not need to be declared or handled by the application code where it is thrown. Unchecked exceptions are often referred to as runtime exceptions, although in Java, unchecked exceptions include any class that inherits RuntimeException or Error.

NOTE:- t is permissible to handle or declare an unchecked exception. That said, it is better to document the unchecked exceptions callers should know about in a Javadoc comment rather than declaring an unchecked exception.

A runtime exception is defined as the RuntimeException class and its subclasses. Runtime exceptions tend to be unexpected but not necessarily fatal. For example, accessing an invalid array index is unexpected. Even though they do inherit the Exception class, they are not checked exceptions.
An unchecked exception can occur on nearly any line of code, as it is not required to be handled or declared. For example, a NullPointerException can be thrown in the body of the following method if the input reference is null:

```java
void fall(String input) {
System.out.println(input.toLowerCase());
}
```

We work with objects in Java so frequently that a NullPointerException can happen almost anywhere. If you had to declare unchecked exceptions everywhere, every single method would have that clutter! The code will compile if you declare an unchecked exception. However, it is redundant.
