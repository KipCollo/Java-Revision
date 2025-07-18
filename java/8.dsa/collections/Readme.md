# Collections Framework

Java's Collection framework provides a way to store and manipulate groups of objects. Java Collections can be used for searching, sorting, inserting, manipulating, and deleting data.
In Java, a collection is a single unit of objects. ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet, and LinkedList are all classes of Java Collection framework.

A collection is a group of objects contained in a single object.The Java Collections framework is a set of classes in java.util package for storing collections.
There are five main interfaces:-

1. `Map` :An object that maps keys to values. A map is not ordered and cannot contain duplicate keys (but can contain duplicate values). Each key can map to at most one value.
2. `Collection` :A collection represents a group of objects, known as its elements. The JDK provides implementations of more specific subinterfaces like Set and List.
3. `List` :A list is an ordered list of objects, where the same object may well appear more than once. For example: [1, 7, 1, 3, 1, 1, 1, 5]. You can add an element anywhere in the list, change an element anywhere in the list, or remove an element from any position in the list.
4. `Queue` :A queue is also ordered, but you'll only ever touch elements at one end. All elements get inserted at the "end" and removed from the "beginning" (or head) of the queue. You can find out how many elements are in the queue,.
5. `Set` :A set is not ordered and cannot contain duplicates. Any given object either is or isn't in the set. {7, 5, 3, 1} is the exact same set as {1, 7, 3, 5}. You can add or remove elements, and you can find out if a certain element exists.

NOTE:- Map doesn't implements the Collection interface.It is considered a part of the Collection framework even though it isn't technically a collection.

<table class="alt">
<tbody>
<tr><th> </th><th>List</th><th>Set</th><th>Queue</th><th>Map</th></tr>
<tr><th>Order</th><th>Yes</th><th>No</th><th>Yes</th><th>No</th></tr>
<tr><th>Duplicates</th><th>Yes</th><th>No</th><th>Yes</th><th>No (Allow duplicate values not keys)</th></tr>
<tr><th>Null Values</th><th>Yes</th><th>Single Null</th><th>Yes (LinkedList Queue). No (Priority Queue).</th><th>Single null key and many null values</th></tr>
</tbody></table>

## Hierarchy of Collection Interface :

![collection-hierarchy](https://user-images.githubusercontent.com/2780145/34073817-62945de4-e2c8-11e7-820b-84f9dad32af3.png)

Methods of Collection Interface:-

1. public boolean add(Object element)- is used to insert an element in this collection.
2. public boolean addAll(Collection c)- is used to insert the specified collection elements in the invoking collection.
3. public boolean remove(Object element)- is used to delete an element from this collection.
4. public boolean removeAll(Collection c)- is used to delete all the elements of specified collection from the invoking collection.
5. public boolean retainAll(Collection c)- is used to delete all the elements of invoking collection except the specified collection.
6. public int size()- return the total number of elements in the collection.
7. public void clear()- removes the total no of element from the collection.
8. public boolean contains(Object element)- is used to search an element.
9. public boolean containsAll(Collection c)-is used to search the specified collection in this collection.
10. public Iterator iterator()- returns an iterator.
11. public Object[] toArray()- converts collection into array.
12. public boolean isEmpty()- checks if collection is empty.
13. public boolean equals(Object element) - matches two collection.
14. public int hashCode() - returns the hashcode number for collection.

Methods of Iterator Interface :-

<table class="alt">
<tbody><tr><th>No.</th><th>Method</th><th>Description</th></tr>
<tr><td>1</td><td>public boolean hasNext()</td><td>It returns true if iterator has more elements.</td></tr>
<tr><td>2</td><td>public Object next()</td><td>It returns the element and moves the cursor pointer to the next element.</td></tr>
<tr><td>3</td><td>public void remove()</td><td>It removes the last elements returned by the iterator. It is rarely used.</td></tr>
</tbody></table>

## ArrayList vs LinkedList :

<table class="alt">
<tbody><tr><th>ArrayList</th><th>LinkedList</th></tr>
<tr><td>1) ArrayList internally uses <strong>dynamic array</strong> to store the elements.</td><td>LinkedList internally uses <strong>doubly linked list</strong> to store the elements.</td></tr>
<tr><td>2) Manipulation with ArrayList is <strong>slow</strong> because it internally uses array. If any element is removed from the array, all the bits are shifted in memory.</td><td>Manipulation with LinkedList is <strong>faster</strong> than ArrayList because it uses doubly linked list so no bit shifting is required in memory.</td></tr>
<tr><td>3) ArrayList class can <strong>act as a list</strong> only because it implements List only.</td><td>LinkedList class can <strong>act as a list and queue</strong> both because it implements List and Deque interfaces.</td></tr>
<tr><td>4) ArrayList is <strong>better for storing and accessing</strong> data.</td><td>LinkedList is <strong>better for manipulating</strong> data.</td></tr>
</tbody></table>

## ArrayList vs Vector :

<table class="alt">
<tbody><tr><th>ArrayList</th><th>Vector</th></tr>
<tr><td>1) ArrayList is <strong>not synchronized</strong>.</td><td>Vector is <strong>synchronized</strong>.</td></tr>
<tr><td>2) ArrayList <strong>increments 50%</strong> of current array size if number of element exceeds from its capacity.</td><td>Vector <strong>increments 100%</strong> means doubles the array size if total number of element exceeds than its capacity.</td></tr>
<tr><td>3) ArrayList is <strong>not a legacy</strong> class, it is introduced in JDK 1.2.</td><td>Vector is a <strong>legacy</strong> class.</td></tr>
<tr><td>4) ArrayList is <strong>fast</strong> because it is non-synchronized.</td><td>Vector is <strong>slow</strong> because it is synchronized i.e. in multithreading environment, it will hold the other threads in runnable or non-runnable state until current thread releases the lock of object.</td></tr>
<tr><td>5) ArrayList uses <strong>Iterator</strong> interface to traverse the elements.</td><td>Vector uses <strong>Enumeration</strong> interface to traverse the elements. But it can use Iterator also.</td></tr>
</tbody></table>

## Hierarchy of Map Interface :

![hierarchy-of-maps-in-java](https://user-images.githubusercontent.com/2780145/34075635-1a5bba52-e2f2-11e7-8962-384b5bc24ae5.png)

## Useful Methods of Map Interface :

<table class="alt">
<tbody><tr><th>Method</th><th>Description</th></tr>
<tr><td> Object put(Object key, Object value)</td><td>It is used to insert an entry in this map.</td></tr>
<tr><td>void putAll(Map map)</td><td>It is used to insert the specified map in this map.</td></tr>
<tr><td>Object remove(Object key)</td><td>It is used to delete an entry for the specified key.</td></tr>
<tr><td>Object get(Object key)</td><td>It is used to return the value for the specified key.</td></tr>
<tr><td>boolean containsKey(Object key)</td><td>It is used to search the specified key from this map.</td></tr>
<tr><td>Set keySet()</td><td>It is used to return the Set view containing all the keys.</td></tr>
<tr><td>Set entrySet()</td><td>It is used to return the Set view containing all the keys and values.</td></tr>
</tbody></table>

## Methods of Map.Entry Interface :
<table class="alt">
<tbody><tr><th>Method</th><th>Description</th></tr>
<tr><td> Object getKey()</td><td>It is used to obtain key.</td></tr>
<tr><td>Object getValue()</td><td>It is used to obtain value.</td></tr>
</tbody></table>

## HashMap vs HashTable :

<table class="alt">
<tbody><tr><th>HashMap</th><th>Hashtable</th></tr>
<tr><td>1) HashMap is <strong>non synchronized</strong>. It is not-thread safe and can't be shared between many threads without proper synchronization code.</td><td>Hashtable is <strong>synchronized</strong>. It is thread-safe and can be shared with many threads.</td></tr>
<tr><td>2) HashMap <strong>allows one null key and multiple null values</strong>.</td><td>Hashtable <strong>doesn't allow any null key or value</strong>.</td></tr>
<tr><td>3) HashMap is a <strong>new class introduced in JDK 1.2</strong>.</td><td>Hashtable is a <strong>legacy class</strong>.</td></tr>
<tr><td>4) HashMap is <strong>fast</strong>.</td><td>Hashtable is <strong>slow</strong>.</td></tr>
<tr><td>5) We can make the HashMap as synchronized by calling this code<br> Map m = Collections.synchronizedMap(hashMap);</td><td>Hashtable is internally synchronized and can't be unsynchronized.</td></tr>
<tr><td>6) HashMap is <strong>traversed by Iterator</strong>.</td><td>Hashtable is <strong>traversed by Enumerator and Iterator</strong>.</td></tr>
<tr><td>7) Iterator in HashMap is <strong>fail-fast</strong>.</td><td>Enumerator in Hashtable is <strong>not fail-fast</strong>.</td></tr>
<tr><td>8) HashMap inherits <strong>AbstractMap</strong> class.</td><td>Hashtable inherits <strong>Dictionary</strong> class.</td></tr>
</tbody></table>

## Collections Framework Implementation Classes Summary :

## Comparable vs Comparator Interfaces :

<table class="alt">
<tbody><tr><th>Comparable</th><th>Comparator</th></tr>
<tr><td>1) Comparable provides <strong>single sorting sequence</strong>. In other words, we can sort the collection on the basis of single element such as id or name or price etc.</td><td> Comparator provides <strong>multiple sorting sequence</strong>. In other words, we can sort the collection on the basis of multiple elements such as id, name and price etc.</td></tr>
<tr><td>2) Comparable <strong>affects the original class</strong> i.e. actual class is modified.</td><td>Comparator <strong>doesn't affect the original class</strong> i.e. actual class is not modified.</td></tr>
<tr><td>3) Comparable provides <strong>compareTo() method</strong> to sort elements.</td><td>Comparator provides <strong>compare() method</strong> to sort elements.</td></tr>
<tr><td>4) Comparable is found in <strong>java.lang</strong> package.</td><td>Comparator is found in <strong>java.util</strong> package.</td></tr>
<tr><td>5) We can sort the list elements of Comparable type by <strong>Collections.sort(List)</strong> method.</td><td>We can sort the list elements of Comparator type by <strong>Collections.sort(List,Comparator)</strong> method.</td></tr>
</tbody></table>

## Legacy Data Structures in Java

Legacy classes and interfaces are the classes and interfaces that formed the collections framework in the earlier versions of Java and has now been restructured or re-engineered. They are fully compatible with the framework.

All legacy classes were re-engineered to support generic in JDK5.

Legacy = heritage of old java version.

Legacy classes and interfaces - Enumeration, Vector, Stack, Dictionary, HashTable, Properties...

The collections framework consists of:

Collection interfaces - The primary means by which collections are manipulated.
Collection - A group of objects. No assumptions are made about the order of the collection (if any) or whether it can contain
duplicate elements.
Set - The familiar set abstraction. No duplicate elements permitted. May or may not be ordered. Extends the Collection
interface.
List - Ordered collection, also known as a sequence. Duplicates are generally permitted. Allows positional access. Extends the
Collection interface.
Queue - A collection designed for holding elements before processing. Besides basic Collection operations, queues provide
additional insertion, extraction, and inspection operations.
Deque - A double ended queue, supporting element insertion and removal at both ends. Extends the Queue interface.