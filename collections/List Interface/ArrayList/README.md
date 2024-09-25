# ArrayList

- Resizable-array implementation of the List interface.Grows and shrinks in size.

## Constructors

- **ArrayList()** : Creates empty list with initial capacity of ten.
- **ArrayList(initialCapacity)** : Creates empty list with initial capacity specified.
- **ArrayList(Collection c)**:- Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.

## Adding elements to ArrayList

- boolean add(E obj) : Declared in the Collection interface. Adds object to the collection. Returns true if object was added, otherwise returns false.

- void add(int index, E obj) : Declared in the List interface. Adds object obj to the invoking list at the index passed. Any preexisting element at or beyond the index are shifted up. Thus no elements are overwritten.

- boolean addAll(Collection c) : Declared in the Collection interface. Adds all the elements of c to the invoking collection. Returns true if elements were added to the invoking collection. Otherwise, returns false.

- boolean addAll(int index, Collection c) : Declared in the List interface. Adds all the elements of c to the invoking list at the index passed. Any
preexisting element at or beyond the index are shifted up. Thus no elements are overwritten. Returns true if elements were added to the invoking list.Otherwise, returns false.

 ## Removing elements from ArrayList
 
 - boolean remove(Object obj) : Declared in the Collection interface. Removes one instance of obj from the invoking collection. Returns true if the element was removed. Otherwise, returns false.
 
 - boolean removeAll(Collection c) : Declared in the Collection interface. Removes all elements of c from the invoking collection. Returns true if
 elements were removed from the invoking collection. Otherwise, returns false.
	
 - E remove(int index) : Declared in the List interface. Removes the element at the specified index from the invoking list, returning the element in the process. The indexes of the subsequent elements are decremented by one.
	
- boolean retainAll(Collection c) : Declared in the Collection interface. Removes all elements from the invoking collection except those in c. Returns true if elements were removed from the invoking collection. Otherwise,returns false.
	
## Check if ArrayList contains an object

- boolean contains(Object obj) : Declared in the Collection interface. Returns true if obj is an element of the invoking collection. Otherwise, returns false.

- boolean containsAll(Collection c) : Declared in the Collection interface. Returns true if the invoking collection contains all elements of c.
Otherwise, returns false.

 ## Get the element at an index in ArrayList

		 *E get(int index) : Declared in the List interface. Returns the object stored
		 *at the specified index within the invoking collection.
