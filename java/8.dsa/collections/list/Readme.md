# List Interface

List is an ordered collection.It maintains the insertion order, meaning it will display elements in same order in which they got inserted.It provides control over position where you can insert element.

You can access elements by their index and also search elements in list.It allows duplicate items, allows 'null' elements.

Some implementations include: ArrayList, LinkedList, Vectors, Stack, CopyOnWriteArrayList.

List are commonly used because there are many situations in programming where you need to keep track of list of objects.

The 'List' interface extends the 'Collection' interface and declares the behavior of a collection that stores a sequence of elements. Elements can be added or accessed by their position in the list, using a zero-based index. A list may also contain duplicate elements.

An arrayList is like resizable array. When elements are added, the ArrayList automatically grows. When you aren’t sure which collection to use, use an ArrayList.The main benefit of an ArrayList is that you can look up any element in constant time.Adding or removing an element is slower than accessing an element. This makes an ArrayList
a good choice when you are reading more often than (or the same amount as) writing to the ArrayList.
A LinkedList is special because it implements both List and Deque. It has all the methods of a List. It also has additional methods to facilitate adding or removing from the beginning and/or end of the list.The main benefits of a LinkedList are that you can access, add to, and remove from the beginning and end of the list in constant time. The trade-­off is that dealing with an arbitrary index takes linear time. This makes a LinkedList a good choice when you’ll be using it as Deque.

## Creating a List with a Factory

When you create a List of type ArrayList or LinkedList, you know the type. There are a few special methods where you get a List back but don’t know the type. These methods
let you create a List including data in one line using a factory method. This is convenient, especially when testing. Some of these methods return an immutable object.

1. Arrays.asList(varargs) - Returns fixed size list backed by an aaray.Cannot add or delete elements but can replace elements.
2. List.of(varargs) - Returns immutable list.Cannot add,replace or delete elements.
3. List.copyof(collection ) - Returns immutable list with copy of original collection's values.Cannot add,replace or delete elements.

```java
String[] array = new String[] {"a", "b", "c"};
List<String> asList = Arrays.asList(array); // [a, b, c]
List<String> of = List.of(array);// [a, b, c]
List<String> copy = List.copyOf(asList);// [a, b, c]

array[0] = "z";

System.out.println(asList);// [z, b, c]
System.out.println(of);// [a, b, c]
System.out.println(copy);// [a, b, c]

asList.set(0, "x");
System.out.println(Arrays.toString(array)); // [x, b, c]

copy.add("y");// UnsupportedOperationException
```
