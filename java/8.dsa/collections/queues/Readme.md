# Queue

The 'Queue' interface extends 'Collection' interface and declares the behaviour of a queue. 'Queue' being an interface needs a class which provides implementation to its methods and also that we can create objects of that class. 'LinkedList' and 'PriorityQueue' are the most commonly used classes used while creating a queue object.

A queue is an ordered list of objects which are processed in a first-in, first-out (FIFO) manner, i.e. elements are inserted at the tail or rear-end of the queue whereas removal of elements occur at the head or front-end of the queue.

The Queue interface contains 6 methods.There are three pieces of functionality and versions of the methods that throw an exception or use the return type, such as null, for all information.

1. public boolean add(E e) - Add to back.
2. public boolean offer(E e) - Add to back.
3. public E element() - Read from front.
4. public E peek() - Read from front
5. public E remove() - Get and remove from front.
6. public E poll() - Get and remove from front.

## Deque

Deque interface supports double-­ended queues, it inherits all Queue methods and adds more so that it is clear if we are working with the front or back of the queue.
Deque methods includes:-

1. public void addFirst(E e) - Add to front.
2. public boolean offerFirst(E e)
3. public boolean addLast(E e) - Add to back.
4. public boolean offerLast(E e)
5. public E getFirst() - Read from front.
6. public E peekFirst()
7.  public E getLast() - Read from back.
8. public E peekLast()
9. public E removeFirst() - Get and remove from front.
10. public E pollFirst()
11. public E removeLast() - get and remove from back.
12. public E pollLast()