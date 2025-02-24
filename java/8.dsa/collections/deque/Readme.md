# Deque

A deque (double-ended queue) functions as queues (first-in, first-out) or as stacks (last-in, first-out).

The 'Deque' interface extends 'Queue' interface and declares the behaviour of a double-ended queue. 'Deque' being an interface needs a class which provides implementation to its methods and also that we can create objects of that class. 'ArrayDeque' class is used used while creating a deque object.

The 'ArrayDeque' class extends 'AbstractCollection' class and implements the 'Deque' interface. 'ArrayDeque' creates a dynamic array and has no capacity restrictions.

## Adding elements to deque

boolean add(E obj) : Declared in the Collection interface. Adds object to the collection. Returns true if object was added, otherwise returns false.

boolean offer(E obj) : Declared in the Queue interface. Adds object to the queue. Returns true if object was added, otherwise returns false.

void addFirst(E obj) : Declared in the Deque interface. Adds obj to the head of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

void addLast(E obj) : Declared in the Deque interface. Adds obj to the tail of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

boolean offerFirst(E obj) : Declared in the Deque interface. Attempts to add obj to the head of the deque. Returns true if obj was added and false otherwise.

boolean offerLast(E obj) : Declared in the Deque interface. Attempts to add obj to the tail of the deque. Returns true if obj was added and false otherwise.

void push(E obj) : Declared in the Deque interface. Adds obj to the head of the deque. Throws an IllegalStateException if a capacity-restricted deque is out of space.

## Removing elements from deque

E remove() : Declared in the Queue interface. Removes the element at the head of the queue returning the element in the process. It throws NoSuchElementException if the queue is empty.

boolean remove(Object obj) : Declared in the Collection interface. Removes one instance of obj from the queue. Returns true if the element was removed.Otherwise, returns false.

E removeFirst() : Declared in the Deque interface. Removes the element at the head of the deque returning the element in the process. It throws NoSuchElementException if the deque is empty.

E removeLast() : Declared in the Deque interface. Removes the element at the tail of the deque returning the element in the process. It throws NoSuchElementException if the deque is empty.

boolean removeFirstOccurrence(Object obj) : Declared in the Deque interface.Removes the first occurrence of obj from the deque. Returns true if successful and false if the deque did not contain obj.

boolean removeLastOccurrence(Object obj) : Declared in the Deque interface.Removes the last occurrence of obj from the deque. Returns true if successful and false if the deque did not contain obj.

## Get the head / tail element of deque

E peek() : Declared in the Queue interface. Returns the element at the head of the queue. It returns null if the queue is empty.

E peekFirst() : Declared in the Deque interface. Returns the element at the head of the deque. It returns null if the deque is empty. The object is not removed.

E peekLast() : Declared in the Deque interface. Returns the element at the tail of the deque. It returns null if the deque is empty. The object is nremoved.

E getFirst() : Declared in the Deque interface. Returns the first element in the deque. The object is not removed from the deque. It throws NoSuchElementException if the deque is empty.

E getLast() : Declared in the Deque interface. Returns the last element in the deque. The object is not removed from the deque. It throws NoSuchElementException if the deque is empty.
