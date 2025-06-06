# Methods

A method or function is a set of Statements that perform a specific task.It can take input perform operations and return output.A method is defined within a class or an interface.

```java
public final void nap(int minutes)throws InturruptedException{
   //body
}
```

This is called a method declaration, which specifies all the information needed to call the method. There are a lot of parts, and we cover each one in more detail. Two of the parts—­the method name and parameter list—­are called the method signature.
The method signature provides instructions for how callers can reference this method. The method signature does not include the return type and access modifiers, which control where the method can be referenced.

## Explanation

- Access Modifiers:- An access modifier determines what classes a method can be accessed from. Think of it like a security guard. Some classes are good friends, some are distant relatives, and some are complete strangers. Access modifiers help to enforce when these components are allowed to talk to each other. Java offers four choices of access modifier:

1. private The private modifier means the method can be called only from within the same class.
2. Package Access With package access, the method can be called only from a class in the same package. This one is tricky because there is no keyword. You simply omit the
access modifier. Package access is sometimes referred to as package-­private or default access.
3. protected The protected modifier means the method can be called only from a class in the same package or a subclass.
4. public The public modifier means the method can be called from anywhere.

- Optional Specifiers:- There are a number of optional specifiers for methods.Unlike with access modifiers, you can have multiple specifiers in the same method (although not all combinations are legal). When this happens, you can specify them in any order. And since these specifiers are optional, you are allowed to not have any of them at all. This means you can have zero or more specifiers in a method declaration:-

1. static - Indicates the method is a member of the shared class object
2. abstract - Used in an abstract class or interface when the method body is excluded.
3. final - Specifies that the method may not be overridden in a sub-class
4. default - Used in an interface to provide a default implementation of a method for classes that implement the interface
5. synchronized - Used with multithreaded code
6. native - Used when interacting with code written in another ­language, such as C++
7. strictfp - Used for making floating-­point calculations portable

NOTE:- While access modifiers and optional specifiers can appear in any order, they must all appear before the return type. In practice, it is common to list the access modifier first.

- Return Type:- The next item in a method declaration is the return type. It must appear after any access modifiers or optional specifiers and before the method name. The return type might be an actual Java type such as String or int. If there is no return type, the void keyword is used.This special return type comes from the English language: void means without contents.
When checking return types, you also have to look inside the method body. Methods with a return type other than void are required to have a return statement inside the method body. This return statement must include the primitive or object to be returned. Methods that have a return type of void are permitted to have a return statement with no value returned or omit the return statement entirely.

- Method Name:- An identifier may only contain letters, numbers, currency symbols, or _. Also, the first character is not allowed to be a number, and reserved words are not
allowed. Finally, the single underscore character is not allowed.By convention, methods begin with a lowercase letter, but they are not required to.

- Parameter List:- Although the parameter list is required, it doesn’t have to contain any parameters. This means you can just have an empty pair of parentheses after the method name, as follows:

```java
public class Sleep {
   void nap() {}
}
```

If you do have multiple parameters, you separate them with a comma.

- Method Signature:- A method signature, composed of the method name and parameter list, is what Java uses to uniquely determine exactly which method you are attempting to call. Once it determines which method you are trying to call, it then determines if the call is allowed.
For example,attempting to access a private method outside the class or assigning the return value of a void method to an int variable results in compiler errors. Neither of these compiler errors is related to the method signature, though.

It’s important to note that the names of the parameters in the method signature are not used as part of a method signature. The parameter list is about the types of parameters and their order.

- Exception List:- In Java, code can indicate that something went wrong by throwing an exception.It is optional and where in the method declaration it goes if present.You can list as many types of exceptions as you want in this clause, separated by commas.
While the list of exceptions is optional, it may be required by the compiler, depending on what appears inside the method body.

- Method Body:- The final part of a method declaration is the method body. A method body is simply a code block. It has braces that contain zero or more Java statements.

## Declaring Local and Instance Variables

local variables are those defined with a method or block, while instance variables are those that are defined as a member of a class.

```java
public class Lion {
   int hunger = 4;

   public int feedZooAnimals() {
      int snack = 10; // Local variable
      return snack;
   }
}
```

All local variable references are destroyed after the block is executed, but the objects they point to may still be accessible.

There’s only one modifier that can be applied to a local variable: final.When writing methods, developers may want to set a variable that does not change during the course of the method.

An effectively final local variable is one that is not modified after it is assigned. This means that the value of a variable doesn’t change after it is set, regardless of whether it is explicitly marked as final. If you aren’t sure whether a local variable is effectively final, just add the final keyword. If the code still compiles, the variable is effectively final.

## Instance Variable Modifiers

Like methods, instance variables can use access modifiers, such as private, package, protected, and public. Remember, package access is indicated by the lack of any modifiers.
Optional specifiers for instance variables include:-

1. final - Specifies that the instance variable must be initialized with each instance of the class exactly once.
2. volatile - Instructs the JVM that the value in this variable may be ­modified by other threads
3. transient - Used to indicate that an instance variable should not be ­serialized with the class

## Working with Varargs

A method may use a varargs parameter (variable argument) as if it is an array. Creating a method with a varargs parameter is a bit more complicated. In fact,
calling such a method may not use an array at all.

There are a number of important rules for creating a method with a varargs parameter.

1. A method can have at most one varargs parameter.
2. If a method contains a varargs parameter, it must be the last parameter in the list.

```java
public class VisitAttractions {
public void walk1(int... steps) {}
public void walk2(int start, int... steps) {}
}
```

When calling a method with a varargs parameter, you have a choice. You can pass in an array, or you can list the elements of the array and let Java create it for you.

```java
// Pass an array
int[] data = new int[] {1, 2, 3};
walk1(data);

// Pass a list of values
walk1(1,2,3);
```

Regardless of which one you use to call the method, the method will receive an array containing the elements.

You can even omit the varargs values in the method call, and Java will create an array of length zero for you.

```java
walk1();
```

Accessing a varargs parameter is just like accessing an array. It uses array indexing. Here’s an example:

```java
public static void run(int... steps) {
 System.out.print(steps[1]);
}

public static void main(String[] args) {
run(11, 77);// 77
}
```

## Overloading Methods

Method overloading occurs when methods in the same class have the same name but different method signatures, which means they use different parameter lists.
Everything other than the method name can vary for overloading methods. This means there can be different access modifiers, optional specifiers (like static), return types, and exception lists.

```java
public class Falcon {
public void fly(int numMiles) {}
public void fly(short numFeet) {}
public boolean fly() { return false; }
void fly(int numMiles, short numFeet) {}
public void fly(short numFeet, int numMiles) throws Exception {}
}
```

## Types of Methods:-

`Instance Methods`:- These methods belong to an instance of a class.Need to create an object of the class to call instance method.Instance methods can access instance variables and call other instance methods of same class.

```java
class Car{
   String color;

   public void displayColor(){
      System.out.println("Car is color: " + color)
   }
}

public void main(){
   Car car = new Car();
   car.displayColor();
}
```

`Static Methods`:- These methods belong to the class rather than to any instance of the class.They are called on the cass itself,not objects.Can only directly access other static members of the class(other static variables and methods).

```java
class MathUtility{
   public static int addNumbers(int a, int b){
      return a + b;
   }
}

public class Main{
   public static void main(String[] args){
      int sum = MathUtility.addNumbers(5,7);
      System.out.println("Sum: " + sum)
   }
}
```

`Abstract Methods`:- These methods are defined in abstract classes and do not have a body.Subclasses of the abstract class must override these methods to provide an implementation.Abstract methods help define a common interface for all subclasses to implement.

```java
abstract class Animal{
   public abstract void makeSound();
}

class Dog extends Animal{

   @Override
   public void makeSound(){
      System.out.println("Woof")
   }
}

public class Main{
   public static void main(String[] args){
      Animal dod = new Dog();
      dog.makeSound();
   }
}
```

`Final Methods`:- Methods that are declared as final cannot be overriden in subclasses.They are typically used to prevent method overridding and maintain consistency.

```java
class Animal{

   public final void sleep(){
      System.out.println("Animal is sleeping")
   }
}

class Dog extends Animal{

   public void sleep(){
      System.out.println("Dog is sleeping") // This will cause an error
   }
}
```
