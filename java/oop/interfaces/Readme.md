# Interface

In an abstract class, we can have both abstract methods as well as normal or concrete methods.

- If your class has only abstract methods then instead of using class, you can simply use an interface in place of it.
- Interface is not any class.
- Every method in an interface is public and abstract by default.
- Even if you do not use two keywords (public and abstract) with methods then also it will not give an error in an interface. By default, it will consider all methods as public and abstract.
- We cannot instantiate an interface.
- Interface only shows the design and it does not provide any implementation.
- To provide an implementation of methods, you need to create a class and instantiate it also.
e.g,
```Java
 interface A
 {
  methods()----
 }
```

## implements keyword:-

To implement an interface, we use the keyword **implements**.
- If you use the implements keyword with class, then it is compulsory to give an implementation of all the methods that are defined in an interface.
- If you do not give an implementation of all methods then it will make your class an abstract class by default.
- So, to make a concrete class, you have to give the implementation of all methods present in an interface.
e.g., 
```Java
 class B implements A
 {
  methods() {
   statement;
  }
  ------
 }
```

## Variables in an interface:-
- We can call the methods of an interface by creating an object of the class that implements an interface.
- We can also declare variables in an interface.
- All the variables in an interface are final and static by default.
- As a variable is static in an interface, then you do not need to create an object for it. You can directly call the variable by using the interface name.
e.g., A.area;    (here, area is a variable initialized in an interface)
- As the variable is final, you can not change the value of that variable after initializing it once.

-Interface does not have its own memory in the heap.

## Types of Interface:-

1. Normal interface - an interface having two or more methods
2. Functional interface (SAM)- SAM => Single Abstract Method interface
3. Marker interface - an interface that as no methods (blank interface)