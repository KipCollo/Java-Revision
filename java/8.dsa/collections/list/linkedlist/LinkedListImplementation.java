// public class LinkedListImplementation {
//     public static void main(String[] args) {
        
//         List<Integer> newlist = new LinkedList<>(); //: Creates empty list
//         List<Integer> newlist1 = new LinkedList<>();



//     }
// }

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;



public class LinkedListImplementation {

	public static void main(String[] args) {

		List<Integer> numList = new LinkedList<>();

	
		// Adding elements to LinkedList
		numList.add(7);
		// numList = [7]

		numList.add(5);
		// numList = [7, 5]

		numList.add(1, 3);
		// numList = [7, 3, 5]

		List<Integer> nums = new LinkedList<>(Arrays.asList(6, 3, 1));

		numList.addAll(nums);
		// numList = [7, 3, 5, 6, 3, 1]

		nums = new LinkedList<>(Arrays.asList(4, 7));

		numList.addAll(4, nums);
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]

		System.out.println("numList = " + numList);
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]

		// Removing elements from LinkedList
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]
		numList.remove(Integer.valueOf(3));
		// numList = [7, 5, 6, 4, 7, 3, 1]

		nums = new LinkedList<>(Arrays.asList(6, 7));

		// removes all occurrences of each element of nums from numList
		numList.removeAll(nums);
		// numList = [5, 4, 3, 1]

		int removedElement = numList.remove(1);
		System.out.println("removedElement = " + removedElement); // removedElement = 4

		System.out.println("numList = " + numList);
		// numList = [5, 3, 1]

		numList.addAll(Arrays.asList(4, 7, 3, 1, 5));
		// numList = [5, 3, 1, 4, 7, 3, 1, 5]

		nums.addAll(Arrays.asList(5, 1));
		// nums = [6, 7, 5, 1]

		numList.retainAll(nums); // Elements [3, 4] are removed from numList
		// numList = [5, 1, 7, 1, 5]

		System.out.println("numList = " + numList);
		// numList = [5, 1, 7, 1, 5]

		// Check if LinkedList contains an object
		int value = 5;

		// numList = [5, 1, 7, 1, 5]
		if (numList.contains(value))
			System.out.println("numList contains " + value);
		else
			System.out.println("numList does not contain " + value);

		nums = new LinkedList<>(Arrays.asList(5, 7));

		// numList = [5, 1, 7, 1, 5]
		if (numList.containsAll(nums))
			System.out.println("numList contains all elements of nums");
		else
			System.out.println("numList does not contain all elements of nums");

		// Get the element at an index in LinkedList
		// numList = [5, 1, 7, 1, 5]
		int element = numList.get(2);

		System.out.println("element = " + element); // element = 7

		// Get the index of an element in LinkedList
		// numList = [5, 1, 7, 1, 5]
		int lastIndex = numList.lastIndexOf(5);

		System.out.println("lastIndex = " + lastIndex); // lastIndex = 4

		//Set the element at an index in LinkedList

		// numList = [5, 1, 7, 1, 5]
		int oldValue = numList.set(3, 9);

		System.out.println("oldValue = " + oldValue); // oldValue = 1

		System.out.println("numList = " + numList); // numList = [5, 1, 7, 9, 5]

		/*
		 * Check if LinkedList is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		// numList = [5, 1, 7, 9, 5]
		if (numList.isEmpty())
			System.out.println("LinkedList is empty");
		else
			System.out.println("LinkedList is not empty");

		/*
		 * Get the count of elements present in the LinkedList
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		// numList = [5, 1, 7, 9, 5]
		int listSize = numList.size();

		System.out.println("Size = " + listSize); // Size = 5

		/*
		 * Get sub-list from an LinkedList
		 * 
		 * List<E> subList(int startIndex, int endIndex) : Declared in the List
		 * interface. Returns a list that includes elements from startIndex to (endIndex
		 * - 1) in the invoking list. Elements in the returned list are also referenced
		 * by the invoking object.
		 */

		// numList = [5, 1, 7, 9, 5]
		List<Integer> subLinkedList = new LinkedList<Integer>();

		subLinkedList = numList.subList(1, 4);

		System.out.println("subLinkedList = " + subLinkedList); // subLinkedList = [1, 7, 9]

		/*
		 * Clear the LinkedList
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		// numList = [5, 1, 7, 9, 5]
		numList.clear();

		System.out.println("numList = " + numList); // numList = []

		/*
		 * Construct LinkedList from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange", "grape" };

		List<String> fruitList = new LinkedList<>();

		Collections.addAll(fruitList, fruits);

		System.out.println("fruitList = " + fruitList);
		// fruitList = [apple, grape, banana, orange, grape]

		/*
		 * Construct array from LinkedList
		 */

		String fruitArr[] = fruitList.toArray(new String[fruitList.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr));
		// fruitArr = [apple, grape, banana, orange, grape]

		/*
		 * Iterating over the contents of a LinkedList
		 * 
		 * Iterator<E> iterator() : Declared in the Collection interface. Returns an
		 * iterator for the invoking collection.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		Iterator itr = fruitList.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		// Iterate using for-each loop

		// fruitList = [apple, grape, banana, orange, grape]
		for (String fruit : fruitList) {
			System.out.print(fruit + " ");
		}

		System.out.println();

		/*
		 * ListIterator<E> listIterator() : Declared in the List interface. Returns an
		 * iterator to invoking list starting from the first element.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		ListIterator listItr = fruitList.listIterator();

		while (listItr.hasNext()) {
			System.out.print(listItr.next() + " ");
		}

		System.out.println();

		/*
		 * ListIterator<E> listIterator(int index) : Declared in the List interface.
		 * Returns an iterator to invoking list starting from the element at the
		 * specified index.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		ListIterator listIndexItr = fruitList.listIterator(2);

		while (listIndexItr.hasNext()) {
			System.out.print(listIndexItr.next() + " ");
		}

		System.out.println();

		/*
		 * Methods declared by the 'Queue', 'Deque' interfaces
		 */

		LinkedList<Integer> demoList = new LinkedList<>();

		// Adding elements to LinkedList
		demoList.add(10);
		// demoList = [10]

		demoList.offer(20);
		// demoList = [10, 20]

		demoList.addFirst(30);
		// demoList = [30, 10, 20]

		demoList.addLast(40);
		// demoList = [30, 10, 20, 40]

		demoList.offerFirst(50);
		// demoList = [50, 30, 10, 20, 40]

		demoList.offerLast(60);
		// demoList = [50, 30, 10, 20, 40, 60]

		demoList.push(70);
		// demoList = [70, 50, 30, 10, 20, 40, 60]

		System.out.println("demoList = " + demoList);
		// demoList = [70, 50, 30, 10, 20, 40, 60]

		// Removing elements from LinkedList

		// demoList = [70, 50, 30, 10, 20, 40, 60]
		demoList.remove();
		// demoList = [50, 30, 10, 20, 40, 60]

		demoList.remove(2);
		// demoList = [50, 30, 20, 40, 60]

		demoList.removeFirst();
		// demoList = [30, 20, 40, 60]

		demoList.removeLast();
		// demoList = [30, 20, 40]

		demoList.addLast(20);
		// demoList = [30, 20, 40, 20]

		demoList.removeFirstOccurrence(20);
		// demoList = [30, 40, 20]

		demoList.addFirst(20);
		// demoList = [20, 30, 40, 20]

		demoList.removeLastOccurrence(20);
		// demoList = [20, 30, 40]

		System.out.println("demoList = " + demoList); // demoList = [20, 30, 40]

		// Get the head / tail element of LinkedList

		// demoList = [20, 30, 40]
		int headElement = demoList.peek();

		System.out.println("headElement = " + headElement); // headElement = 20

		headElement = demoList.peekFirst();

		System.out.println("headElement = " + headElement); // headElement = 20

		int tailElement = demoList.peekLast();

		System.out.println("tailElement = " + tailElement); // tailElement = 40

		headElement = demoList.getFirst();

		System.out.println("headElement = " + headElement); // headElement = 20

		tailElement = demoList.getLast();

		System.out.println("tailElement = " + tailElement); // tailElement = 40

		// Get & remove the head / tail element of LinkedList

		demoList.addFirst(10);
		demoList.addLast(50);

		// demoList = [10, 20, 30, 40, 50]
		removedElement = demoList.poll();

		System.out.println("removedElement = " + removedElement); // removedElement = 10

		// demoList = [20, 30, 40, 50]
		removedElement = demoList.pop();

		System.out.println("removedElement = " + removedElement); // removedElement = 20

		// demoList = [30, 40, 50]
		removedElement = demoList.pollFirst();

		System.out.println("removedElement = " + removedElement); // removedElement = 30

		// demoList = [40, 50]
		removedElement = demoList.pollLast();

		System.out.println("removedElement = " + removedElement); // removedElement = 50

		System.out.println("demoList = " + demoList); // demoList = [40]

		// Reverse order iteration over the contents of a LinkedList
		demoList = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
		// demoList = [10, 20, 30, 40, 50]

		Iterator reverseItr = demoList.descendingIterator();

		while (reverseItr.hasNext()) {
			System.out.print(reverseItr.next() + " ");
		}
		// 50 40 30 20 10

	}

}

