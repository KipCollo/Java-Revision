# Polymorphism

It is object existing in different forms.It is implemented with abstract and concrete classes in java.

## Abstract class

- Abstract methods can only be defined in an abstract class.
- We need to add an abstract keyword before a class to make it an abstract class.
- Objects of an abstract class can not be created.
- If you are extending an abstract class, then it is compulsory to define all abstract methods.
- It is not necessary that an abstract class should have an abstract method.
- Abstract class can have an abstract or a normal method or both.
- An abstract class can have more than one abstract method.

An abstract class is a class declared with the abstract modifier that cannot be instantiated directly and may contain abstract methods. Let’s take a look at an
example based on the Canine data model:

```java
public abstract class Canine {}
public class Wolf extends Canine {}
public class Fox extends Canine {}
public class Coyote extends Canine {}
```

In this example, other developers can create instances of Wolf, Fox, or Coyote, but not Canine. Sure, they can pass a variable reference as a Canine, but the underlying object must be a subclass of Canine at runtime.
But wait, there’s more! An abstract class can contain abstract methods. An abstract method is a method declared with the abstract modifier that does not define a body. Put
another way, an abstract method forces subclasses to override the method.

Why would we want this? Polymorphism, of course! By declaring a method abstract, we can guarantee that some version will be available on an instance without having to specify
what that version is in the abstract parent class.

```java
public abstract class Canine {
public abstract String getSound();
public void bark() { System.out.println(getSound()); }
}
public class Wolf extends Canine {
public String getSound() {
return "Wooooooof!";
} }
public class Fox extends Canine {
public String getSound() {
return "Squeak!";
} }
public class Coyote extends Canine {
public String getSound() {
return "Roar!";
} }
```

We can then create an instance of Fox and assign it to the parent type Canine. The overridden method will be used at runtime.

```java
public static void main(String[] p) {
Canine w = new Fox();
w.bark(); // Squeak!
}
```

Easy so far. But there are some rules you need to be aware of:

1. Only instance methods can be marked abstract within a class, not variables, constructors, or static methods.
2. An abstract method can only be declared in an abstract class.
3. A non-­abstract class that extends an abstract class must implement all inherited abstract methods.
4. Overriding an abstract method follows the existing rules for overriding methods that you learned about earlier in the chapter.

An abstract class can be initialized, but only as part of the instantiation of a non-­abstract subclass

### Abstract Methods

- Instead of defining the method, we can declare the method.
- If we put a semicolon at the end of a method, it means that you only declare the method like:

```Java
 public void drive();
 ```

- This method does not contain any features and you will not be able to create an object of it.
- You need to add an abstract keyword to only declare a method.

An abstract method is always declared without a body. It also includes a semicolon (;) after the method declaration. As you saw in the previous example, an abstract class may include non-­abstract methods, in this case with the bark() method. In fact, an abstract class can include all of the same members as a non-­abstract class, including variables, static and instance methods, constructors, etc.
It might surprise you to know that an abstract class is not required to include any abstract methods. For example, the following code compiles even though it doesn’t define
any abstract methods:

```java
public abstract class Llama {
public void chew() {}
}
```

Even without abstract methods, the class cannot be directly instantiated. For the exam,keep an eye out for abstract methods declared outside abstract classes, such as the following:

```java
public class Egret { // DOES NOT COMPILE
public abstract void peck();
}
```

The exam creators like to include invalid class declarations, mixing non-­abstract classes with abstract methods.
Like the final modifier, the abstract modifier can be placed before or after the access modifier in class and method declarations, as shown in this Tiger class:

```java
abstract public class Tiger {
abstract public int claw();
}
```

The abstract modifier cannot be placed after the class keyword in a class declaration or after the return type in a method declaration. The following Bear and howl() declarations do not compile for these reasons:

```java
public class abstract Bear { // DOES NOT COMPILE
public int abstract howl(); // DOES NOT COMPILE
}
```

NOTE: It is not possible to define an abstract method that has a body or default implementation. You can still define a default method with a body—­you just can’t mark it as abstract. As long as you do not mark the method as final, the subclass has the option to override the inherited method.

## Concrete class

- A class other than an abstract class is known as a concrete class.
- An object of a concrete class can be created.

When designing a model, we sometimes want to create an entity that cannot be instantiated directly. For example, imagine that we have a Canine class with subclasses Wolf, Fox, and Coyote. We want other developers to be able to create instances of the subclasses, but perhaps we don’t want them to be able to create a Canine instance. In other words, we want to force all objects of Canine to have a particular type at runtime.

An abstract class becomes usable when it is extended by a concrete subclass. A concrete class is a non-­abstract class. The first concrete subclass that extends an abstract class is required to implement all inherited abstract methods. This includes implementing any inherited abstract methods from inherited interfaces.
When you see a concrete class extending an abstract class on the exam, check to make sure that it implements all of the required abstract methods. Can you see why the following
Walrus class does not compile?

```java
public abstract class Animal {
public abstract String getName();
}
public class Walrus extends Animal {} // DOES NOT COMPILE
```

In this example, we see that Animal is marked as abstract and Walrus is not, making Walrus a concrete subclass of Animal. Since Walrus is the first concrete subclass, it must implement all inherited abstract methods—­getName() in this example. Because it doesn’t,the compiler reports an error with the declaration of Walrus.

An abstract class can extend a non-­abstract class and vice versa. Anytime a concrete class is extending an abstract class, it must mplement all of the methods that are inherited as abstract. Let’s illustrate this with a set of inherited classes:

```java
public abstract class Mammal {
abstract void showHorn();
abstract void eatLeaf();
}
public abstract class Rhino extends Mammal {
void showHorn() {} // Inherited from Mammal
}
public class BlackRhino extends Rhino {
void eatLeaf() {}
// Inherited from Mammal
}
```
