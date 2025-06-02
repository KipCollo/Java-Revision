# ArrayList

- Resizable-array implementation of the List interface.An ArrayList is a dynamic-sized array. It grows and shrinks in size dynamically as we keep on adding or removing elements. 

The 'ArrayList' class extends the 'AbstractList' class and implements the 'List' interface.

It internally uses an array to store elemnts. Just like array it allows you to retreive elements by their index.
	
Allows duplicate and null values.Is an ordered collection and maintains order. Cannot create an ArrayList of primitives type.You use boxed types e.g Integer,Boolean

Java Arraylist is not synchronized. If multiple threads is required try to modify then outcome wil be non-deterministicYou must explicitly sysnchronize access if multiple threads gonna modify it.

## Constructors

- **ArrayList()** : Creates empty list with initial capacity of ten.
- **ArrayList(initialCapacity)** : Creates empty list with initial capacity specified.
- **ArrayList(Collection c)**:- Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.

## Methods

`Adding elements to ArrayList`:-

- boolean add(E obj) : Declared in the Collection interface. Adds object to the collection. Returns true if object was added, otherwise returns false.

- void add(int index, E obj) : Declared in the List interface. Adds object obj to the invoking list at the index passed. Any preexisting element at or beyond the index are shifted up. Thus no elements are overwritten.

- boolean addAll(Collection c) : Declared in the Collection interface. Adds all the elements of c to the invoking collection. Returns true if elements were added to the invoking collection. Otherwise, returns false.

- boolean addAll(int index, Collection c) : Declared in the List interface. Adds all the elements of c to the invoking list at the index passed. Any
preexisting element at or beyond the index are shifted up. Thus no elements are overwritten. Returns true if elements were added to the invoking list.Otherwise, returns false.

`Removing elements from ArrayList`:-

- boolean remove(Object obj) : Declared in the Collection interface. Removes one instance of obj from the invoking collection. Returns true if the element was removed. Otherwise, returns false.
 
- boolean removeAll(Collection c) : Declared in the Collection interface. Removes all elements of c from the invoking collection. Returns true if
 elements were removed from the invoking collection. Otherwise, returns false.
	
- E remove(int index) : Declared in the List interface. Removes the element at the specified index from the invoking list, returning the element in the process. The indexes of the subsequent elements are decremented by one.
	
- boolean retainAll(Collection c) : Declared in the Collection interface. Removes all elements from the invoking collection except those in c. Returns true if elements were removed from the invoking collection. Otherwise,returns false.
	
`Check if ArrayList contains an object`:-

- boolean contains(Object obj) : Declared in the Collection interface. Returns true if obj is an element of the invoking collection. Otherwise, returns false.

- boolean containsAll(Collection c) : Declared in the Collection interface. Returns true if the invoking collection contains all elements of c.
Otherwise, returns false.

`Get the element at an index in ArrayList`:-

- E get(int index) : Declared in the List interface. Returns the object stored at the specified index within the invoking collection.

`Get the index of an element in ArrayList`:-

- int indexOf(Object obj) : Declared in the List interface. Returns the index of the first instance of obj in the invoking list. If obj is not present in the list, -1 is returned.
- int lastIndexOf(Object obj) : Declared in the List interface. Returns the index of the last instance of obj in the invoking list. If obj is not present in the list, -1 is returned.

`Set the element at an index in ArrayList`:-

- E set(int index, E obj) : Declared in the List interface. Assigns obj to the location specified by index within the invoking list. Returns the old value.

`Check if ArrayList is empty or not`:-

- boolean isEmpty() : Declared in the Collection interface. Returns true if the invoking collection is empty. Otherwise, returns false.

`Get the count of elements present in the ArrayList`:-

- int size() : Declared in the Collection interface. Returns the number of elements held in the invoking collection.
		
`Get sub-list from an ArrayList`:-

- List<E> subList(int startIndex, int endIndex) : Declared in the List interface. Returns a list that includes elements from startIndex to (endIndex- 1) in the invoking list Elements in the returned list are also referenced by the invoking object.

`Clear the ArrayList`:-
		 
- void clear() : Declared in the Collection interface. Removes all elementsfrom the invoking collection.

`Iterating over the contents of a ArrayList`:-
		 
- Iterator<E> iterator() : Declared in the Collection interface. Returns an iterator for the invoking collection.

