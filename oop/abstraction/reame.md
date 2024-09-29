# Abstraction
Abstraction is a process of hiding the implementation details and showing only functionality to the user.


## Abstract method:-
- Instead of defining the method, we can declare the method.
- If we put a semicolon at the end of a method, it means that you only declare the method like:
```Java
 public void drive();
 ```
- This method does not contain any features and you will not be able to create an object of it.
- You need to add an abstract keyword to only declare a method.

## Abstract class:-
- Abstract methods can only be defined in an abstract class.
- We need to add an abstract keyword before a class to make it an abstract class.
- Objects of an abstract class can not be created.
- If you are extending an abstract class, then it is compulsory to define all abstract methods.
- It is not necessary that an abstract class should have an abstract method.
- Abstract class can have an abstract or a normal method or both.
- An abstract class can have more than one abstract method.

## Concrete class: 
- A class other than an abstract class is known as a concrete class.
- An object of a concrete class can be created.