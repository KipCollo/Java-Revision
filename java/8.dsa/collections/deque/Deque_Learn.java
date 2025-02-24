package datastructures.collections.queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class Deque_Learn {

	public static void main(String[] args) {


		Deque<Integer> demoDeque = new ArrayDeque<>();

    	//Adding elements to deque

		demoDeque.add(10);
		// demoDeque = [10]

		demoDeque.offer(20);
		// demoDeque = [10, 20]

		demoDeque.addFirst(30);
		// demoDeque = [30, 10, 20]

		demoDeque.addLast(40);
		// demoDeque = [30, 10, 20, 40]

		demoDeque.offerFirst(50);
		// demoDeque = [50, 30, 10, 20, 40]

		demoDeque.offerLast(60);
		// demoDeque = [50, 30, 10, 20, 40, 60]

		demoDeque.push(70);
		// demoDeque = [70, 50, 30, 10, 20, 40, 60]

		System.out.println("demoDeque = " + demoDeque); // demoDeque = [70, 50, 30, 10, 20, 40, 60]

		// Removing elements from deque
		 
		// demoDeque = [70, 50, 30, 10, 20, 40, 60]
		demoDeque.remove();
		// demoDeque = [50, 30, 10, 20, 40, 60]

		demoDeque.remove(10);
		// demoDeque = [50, 30, 20, 40, 60]

		demoDeque.removeFirst();
		// demoDeque = [30, 20, 40, 60]

		demoDeque.removeLast();
		// demoDeque = [30, 20, 40]

		demoDeque.addLast(20);
		// demoDeque = [30, 20, 40, 20]

		demoDeque.removeFirstOccurrence(20);
		// demoDeque = [30, 40, 20]

		demoDeque.addFirst(20);
		// demoDeque = [20, 30, 40, 20]

		demoDeque.removeLastOccurrence(20);
		// demoDeque = [20, 30, 40]

		System.out.println("demoDeque = " + demoDeque); // demoDeque = [20, 30, 40]


		// Get the head / tail element of deque
		// demoDeque = [20, 30, 40]
		int headElement = demoDeque.peek();

		System.out.println("headElement = " + headElement); // headElement = 20

		headElement = demoDeque.peekFirst();

		System.out.println("headElement = " + headElement); // headElement = 20

		int tailElement = demoDeque.peekLast();

		System.out.println("tailElement = " + tailElement); // tailElement = 40

		headElement = demoDeque.getFirst();

		System.out.println("headElement = " + headElement); // headElement = 20

		tailElement = demoDeque.getLast();

		System.out.println("tailElement = " + tailElement); // tailElement = 40

		/*
		 * Get & remove the head / tail element of deque
		 * 
		 * E poll() : Declared in the Queue interface. Returns the element at the head
		 * of the queue, removing the element in the process. It returns null if the
		 * queue is empty.
		 * 
		 * E pop() : Declared in the Deque interface. Returns the element at the head of
		 * the deque, removing it in the process. It throws NoSuchElementException if
		 * the deque is empty.
		 * 
		 * E pollFirst() : Declared in the Deque interface. Returns the element at the
		 * head of the deque, removing the element in the process. It returns null if
		 * the deque is empty.
		 * 
		 * E pollLast() : Declared in the Deque interface. Returns the element at the
		 * tail of the deque, removing the element in the process. It returns null if
		 * the deque is empty.
		 */

		demoDeque.addFirst(10);
		demoDeque.addLast(50);

		// demoDeque = [10, 20, 30, 40, 50]
		int removedElement = demoDeque.poll();

		System.out.println("removedElement = " + removedElement); // removedElement = 10

		// demoDeque = [20, 30, 40, 50]
		removedElement = demoDeque.pop();

		System.out.println("removedElement = " + removedElement); // removedElement = 20

		// demoDeque = [30, 40, 50]
		removedElement = demoDeque.pollFirst();

		System.out.println("removedElement = " + removedElement); // removedElement = 30

		// demoDeque = [40, 50]
		removedElement = demoDeque.pollLast();

		System.out.println("removedElement = " + removedElement); // removedElement = 50

		System.out.println("demoDeque = " + demoDeque); // demoDeque = [40]

		/*
		 * Get the count of elements present in the deque
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		// demoDeque = [40]
		int dequeSize = demoDeque.size();

		System.out.println("Size = " + dequeSize); // Size = 1

		/*
		 * Check if deque is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		if (demoDeque.isEmpty())
			System.out.println("Deque is empty !");
		else
			System.out.println("Deque is not empty !");

		/*
		 * Check if an object is present the deque
		 * 
		 * boolean contains(Object obj) : Declared in the Collection interface. Returns
		 * true if obj is an element of the invoking collection. Otherwise, returns
		 * false.
		 */

		int value = 40;

		if (demoDeque.contains(value))
			System.out.println("Deque contains " + value);
		else
			System.out.println("Deque does not contain " + value);

		/*
		 * Clear the deque
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		demoDeque.clear();
		// demoDeque = []

		System.out.println("demoDeque = " + demoDeque); // demoDeque = []

		/*
		 * Construct deque from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange" };

		Deque<String> fruitDeque = new ArrayDeque<>();

		Collections.addAll(fruitDeque, fruits);

		System.out.println("fruitDeque = " + fruitDeque); // fruitDeque = [apple, grape, banana, orange]

		/*
		 * Construct array from deque
		 */

		String fruitArr[] = fruitDeque.toArray(new String[fruitDeque.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr)); // fruitArr = [apple, grape, banana, orange]

		/*
		 * Iterating over the contents of a queue
		 * 
		 * Iterator<E> iterator() : Declared in the Collection interface. Returns an
		 * iterator for the invoking collection.
		 * 
		 * Iterator<E> descendingIterator() : Declared in the Deque interface. Returns
		 * an iterator that moves from the tail to the head (reverse iterator) of the
		 * deque.
		 */

		Iterator itr = fruitDeque.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();
		
		Iterator reverseItr = fruitDeque.descendingIterator();
		
		while (reverseItr.hasNext()) {
			System.out.print(reverseItr.next() + " ");
		}
		
		System.out.println();
		
		// Iterate using for-each loop
		
		for (String fruit : fruitDeque) {
			System.out.print(fruit + " ");
		}
		
	}

}

