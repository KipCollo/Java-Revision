# Inheritance

When creating a new class in Java, you can define the class as inheriting from an existing class. Inheritance is the process by which a subclass automatically includes certain members of the class, including primitives, objects, or methods, defined in the parent class.

Is a type of feature through which we can copy properties to a class from upper class.
It rep the IS-A relationship also known as parent-child relationship.In inheritance there are two classes:

- Parent/ Superclass/ Base class
- Child/ Subclass/ Derived class

NOTE: When working with other types, like interfaces, we tend to use the general terms subtype and supertype.

## Declaring a Subclass

Let’s begin with the declaration of a class and its subclass.

```java
public class Mammal{}//superclass
public final class Rhinoceros extends Mammal{}//subclass
```

We indicate a class is a subclass by declaring it with the extends keyword. We don’t need to declare anything in the superclass other than making sure it is not marked final.

One key aspect of inheritance is that it is transitive. Given three classes [X, Y, Z], if X extends Y, and Y extends Z, then X is considered a subclass or descendant of Z. Likewise,Z is a superclass or ancestor of X. We sometimes use the term direct subclass or descendant to indicate the class directly extends the parent class. For example, X is a direct descendant only of class Y, not Z.

When one class inherits from a parent class, all public and protected members are automatically available as part of the child class. If the two classes are in the same package, then package members are available to the child class. Last but not least, private members are restricted to the class they are defined in and are never available
via inheritance. This doesn’t mean the parent class can’t have private members that can hold data or modify an object; it just means the subclass doesn’t have direct access to them.

Let’s take a look at a simple example:

```java
public class BigCat {
protected double size;
}

public class Jaguar extends BigCat {
public Jaguar() {
size = 10.2;
}

public void printDetails() {
System.out.print(size);
}
}

public class Spider {
public void printDetails() {
System.out.println(size);
}
}
```

The final modifier prevents a class from being extended any further. For example, the following does not compile:

```java
public final class Rhinoceros extends Mammal { }
public class Clara extends Rhinoceros { }// DOES NOT COMPILE
```

On the exam, pay attention to any class marked final. If you see another class extending it, you know immediately the code does not compile.

## Single vs. Multiple Inheritance

Java supports single inheritance, by which a class may inherit from only one direct parent class. Java also supports multilevel levels of inheritance, by which one class may extend another class, which in turn extends another class. You can have any number of levels of inheritance, allowing each descendant to gain access to its ancestor’s members.

By design, Java doesn’t support multiple inheritance -by which a class may have multiple direct parents- in the language because multiple inheritance can lead to complex, often difficult-­to-­maintain data models. Java does allow one exception to the single inheritance rule,­a class may implement multiple interfaces.

Diamond problem - When two parent classes inherit from a common ancestor and override the same method, the child class faces ambiguity.This leads to confusion and maintenance challenges.Java philosophy design:-
   1. Simplicity over complexity : Java was designed to be simple, clear, and easy to maintain.
   2. Avoiding ambiguity : Multiple inheritance introduces ambiguity, which conflicts with Java’s goal of being straightforward
   3. “Write Once, Run Anywhere”: Complex inheritance hierarchies could hinder portability and predictability.

## Inheriting Object

In Java, all classes inherit from a single class:java.lang.Object, or Object for short. Furthermore, Object is the only class that doesn’t have a parent class.
The compiler automatically inserts the code into any class you write that doesn’t extend a specific class. For example, the following two are equivalent:

```java
public class Zoo { }
public class Zoo extends java.lang.Object { }
```

The key is that when Java sees you define a class that doesn’t extend another class, the compiler automatically adds the syntax extends java.lang.Object to the class definition. The result is that every class gains access to any accessible methods in the Object class.
For example, the toString() and equals() methods are available in Object; therefore,they are accessible in all classes. Without being overridden in a subclass, though, they may not be particularly useful.

On the other hand, when you define a new class that extends an existing class, Java does not automatically extend the Object class. Since all classes inherit from Object, extending an existing class means the child already inherits from Object by definition. If you look at the inheritance structure of any class, it will always end with Object on the top of the tree

Primitive types such as int and boolean do not inherit from Object, since they are not classes. As you learned in Chapter 5, through autoboxing they can be assigned or passed as an instance of an associated wrapper class, which does inherit Object.

TODO Object class --hashcode(),equals(),toString()--
