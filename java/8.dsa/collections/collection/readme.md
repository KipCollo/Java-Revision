# Collection

The Collections Framework defines several algorithms that can be applied to collections and maps. These algorithms are defined as static methods within the 'Collections' class.

collection interface defines group of elements.

## Need For Collection Framework

- It solves the limitations of arrays
- Are global in nature

## Implementation

JDK has no direct implementation of Collection interface.You can use ArrayList, LinkedList,HashSet..etc to implement it.

## Sorting DaTa

When working with a String, remember that numbers sort before letters, and uppercase letters sort before lowercase letters.

We use Collections.sort(). It returns void because themmethod parameter is what gets sorted.
You can also sort objects that you create yourself. Java provides an interface called Comparable. If your class implements Comparable, it can be used in data structures that require comparison. There is also a class called Comparator, which is used to specify that you want to use a different order than the object itself provides.
