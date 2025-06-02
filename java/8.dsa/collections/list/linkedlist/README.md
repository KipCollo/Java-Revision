# LinkedList

Resizable-array implementation of the List interface.Grows and shrinks in size.

A LinkedList is a linear data structure where elements are stored in non-contiguous memory locations. It grows and shrinks in size dynamically as we keep on adding or removing elements. More intuitively, a linked list is a linear chain of nodes, where each node contains the data and the memory location of the next or previous or both the next and previous nodes. 
 

The 'List' interface extends the 'Collection' interface and declares the behavior of a collection that stores a sequence of elements. Elements can be added or accessed by their position in the list, using a zero-based index. A list may also contain duplicate elements.
		
The 'Queue' interface extends 'Collection' interface and declares the behaviour of a queue. The 'Deque' interface extends 'Queue' interface and declares the behaviour of a double-ended queue.
	 
The 'LinkedList' class extends the 'AbstractSequentialList' class and implements the 'List', 'Queue' and 'Deque' interfaces.
		

## Constructors

- **LinkedList()** : Creates empty list containing all defaults.
- **LinkedList(Collection c)**:- Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.

## Methods In List

`Adding elements to LinkedList`:-
		
boolean add(E obj) : Declared in the Collection interface. Adds object to the collection. Returns true if object was added, otherwise returns false.
		
void add(int index, E obj) : Declared in the List interface. Adds object obj to the invoking list at the index passed. Any preexisting element at or beyond the index are shifted up. Thus no elements are overwritten.
		 
boolean addAll(Collection c) : Declared in the Collection interface. Adds all the elements of c to the invoking collection. Returns true if elements were added to the invoking collection. Otherwise, returns false.
		
boolean addAll(int index, Collection c) : Declared in the List interface.Adds all the elements of c to the invoking list at the index passed. Any preexisting element at or beyond the index are shifted up. Thus no elements are overwritten. Returns true if elements were added to the invoking list.Otherwise, returns false.
		
`Removing elements from LinkedList`:-
		
boolean remove(Object obj) : Declared in the Collection interface. Removes one instance of obj from the invoking collection. Returns true if the element was removed. Otherwise, returns false.
		 
boolean removeAll(Collection c) : Declared in the Collection interface. Removes all elements of c from the invoking collection. Returns true if elements were removed from the invoking collection. Otherwise, returns false.
	
E remove(int index) : Declared in the List interface. Removes the element at the specified index from the invoking list, returning the element in the process. The indexes of the subsequent elements are decremented by one.
		
boolean retainAll(Collection c) : Declared in the Collection interface.Removes all elements from the invoking collection except those in c. Returns true if elements were removed from the invoking collection. Otherwise,returns false.

`Check if LinkedList contains an object`:-
	
boolean contains(Object obj) : Declared in the Collection interface. Returns true if obj is an element of the invoking collection. Otherwise, returns false.
	
boolean containsAll(Collection c) : Declared in the Collection interface.Returns true if the invoking collection contains all elements of c.Otherwise, returns false.
	

`Get the element at an index in LinkedList`:-
	
E get(int index) : Declared in the List interface. Returns the object stored at the specified index within the invoking collection.
	
`Get the index of an element in LinkedList`:-
		
int indexOf(Object obj) : Declared in the List interface. Returns the index of the first instance of obj in the invoking list. If obj is not present in the list, -1 is returned.
	
int lastIndexOf(Object obj) : Declared in the List interface. Returns the index of the last instance of obj in the invoking list. If obj is not present in the list, -1 is returned.

`Set the element at an index in LinkedList`
	
E set(int index, E obj) : Declared in the List interface. Assigns obj to the location specified by index within the invoking list. Returns the old va

## Methods declared by the 'Queue', 'Deque' interfaces

`Adding elements to LinkedList`:-

boolean offer(E obj) : Declared in the Queue interface. Adds object to the queue. Returns true if object was added, otherwise returns false.
		
void addFirst(E obj) : Declared in the Deque interface. Adds obj to the head of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

void addLast(E obj) : Declared in the Deque interface. Adds obj to the tail
of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

boolean offerFirst(E obj) : Declared in the Deque interface. Attempts to add obj to the head of the deque. Returns true if obj was added and false otherwise.
	 
boolean offerLast(E obj) : Declared in the Deque interface. Attempts to add obj to the tail of the deque. Returns true if obj was added and false otherwise.

void push(E obj) : Declared in the Deque interface. Adds obj to the head of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

`Removing elements from LinkedList`:-

E remove() : Declared in the Queue interface. Removes the element at the hef the queue returning the element in the process. It throws NoSuchElementException if the queue is empty.

E removeFirst() : Declared in the Deque interface. Removes the element at the head of the deque returning the element in the process. It throws NoSuchElementException if the deque is empty.

E removeLast() : Declared in the Deque interface. Removes the element at the
 ail of the deque returning the element in the process. It throws NoSuchElementException if the deque is empty.

boolean removeFirstOccurrence(Object obj) : Declared in the Deque interface. Removes the first occurrence of obj from the deque. Returns true if successful and false if the deque did not contain obj.

boolean removeLastOccurrence(Object obj) : Declared in the Deque interface. Removes the last occurrence of obj from the deque. Returns true if successful and false if the deque did not contain obj.

`Get the head / tail element of LinkedList`:-
 
E peek() : Declared in the Queue interface. Returns the element at the head of the queue. It returns null if the queue is empty.
	
E peekFirst() : Declared in the Deque interface. Returns the element at the head of the deque. It returns null if the deque is empty. The object is not removed.
 
E peekLast() : Declared in the Deque interface. Returns the element at the tail of the deque. It returns null if the deque is empty. The object is not removed.
 
E getFirst() : Declared in the Deque interface. Returns the first element in the deque. The object is not removed from the deque. It throws NoSuchElementException if the deque is empty.
 
E getLast() : Declared in the Deque interface. Returns the last element in the deque. The object is not removed from the deque. It throws NoSuchElementException if the deque is empty.

`Get & remove the head / tail element of LinkedList`:-
		
E poll() : Declared in the Queue interface. Returns the element at the head of the queue, removing the element in the process. It returns null if the queue is empty.
		 
E pop() : Declared in the Deque interface. Returns the element at the head of the deque, removing it in the process. It throws NoSuchElementException if the deque is empty.
		  
E pollFirst() : Declared in the Deque interface. Returns the element at the head of the deque, removing the element in the process. It returns null if the deque is empty.
		 
E pollLast() : Declared in the Deque interface. Returns the element at the tail of the deque, removing the element in the process. It returns null if the deque is empty.

`Reverse order iteration over the contents of a LinkedList`:-
		
Iterator<E> descendingIterator(): Declared in the Deque interface. Returns an iterator that moves from the tail to the head (reverse iterator) of the deque.
	
