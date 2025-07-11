
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HashSet_Learn {

	public static void main(String[] args) {

		/*
		 * The 'Set' interface extends 'Collection' interface and specifies the
		 * behaviour of a collection that does not allow duplicate elements.
		 * 
		 * The 'HashSet' class extends the 'AbstractSet' class and implements the 'Set'
		 * interface. It creates a collection that uses a hash table for storage. Also
		 * HashSet does not guarantee the order of its elements.
		 */

		Set<Integer> demoSet = new HashSet<>();

		/*
		 * Adding elements to HashSet
		 * 
		 * boolean add(E obj) : Declared in the Collection interface. Adds object to the
		 * collection. Returns true if object was added to the collection. Returns false
		 * if obj is already a member of the collection and the collection does not
		 * allow duplicates.
		 * 
		 * boolean addAll(Collection c) : Declared in the Collection interface. Adds all
		 * the elements of c to the invoking collection. Returns true if elements were
		 * added to the invoking collection. Otherwise, returns false.
		 */

		demoSet.add(7);
		// demoSet = [7]

		demoSet.add(5);
		// demoSet = [5, 7]

		demoSet.add(3);
		// demoSet = [3, 5, 7]

		demoSet.add(9);
		// demoSet = [3, 5, 7, 9]

		demoSet.add(5); // 5 already exists in demoSet hence not added
		// demoSet = [3, 5, 7, 9]

		if (demoSet.add(3)) // 3 already exists in demoSet hence not added
			System.out.println("Element added to set");
		else
			System.out.println("Duplicate element cannot be added to set");

		System.out.println("demoSet = " + demoSet); // demoSet = [3, 5, 7, 9]

		Set<Integer> numsSet = new HashSet<>(Arrays.asList(4, 7, 3, 6, 8));
		// numsSet = [3, 4, 6, 7, 8]

		numsSet.addAll(Arrays.asList(5, 7, 2, 8, 1, 3)); // duplicate elements are not added
		// numsSet = [1, 2, 3, 4, 5, 6, 7, 8]

		System.out.println("numsSet = " + numsSet); // numsSet = [1, 2, 3, 4, 5, 6, 7, 8]

		/*
		 * Removing elements from HashSet
		 * 
		 * boolean remove(Object obj) : Declared in the Collection interface. Removes
		 * one instance of obj from the invoking collection. Returns true if the element
		 * was removed. Otherwise, returns false.
		 * 
		 * boolean removeAll(Collection c) : Declared in the Collection interface.
		 * Removes all elements of c from the invoking collection. Returns true if
		 * elements were removed from the invoking collection. Otherwise, returns false.
		 * 
		 * boolean retainAll(Collection c) : Declared in the Collection interface.
		 * Removes all elements from the invoking collection except those in c. Returns
		 * true if elements were removed from the invoking collection. Otherwise,
		 * returns false.
		 */

		// demoSet = [3, 5, 7, 9]
		demoSet.remove(7);
		// demoSet = [3, 5, 9]

		System.out.println("demoSet = " + demoSet); // demoSet = [3, 5, 9]

		// numsSet = [1, 2, 3, 4, 5, 6, 7, 8]
		numsSet.removeAll(Arrays.asList(1, 3, 5, 7));
		// numsSet = [2, 4, 6, 8]

		System.out.println("numsSet = " + numsSet); // numsSet = [2, 4, 6, 8]
		
		// numsSet = [2, 4, 6, 8]
		numsSet.retainAll(Arrays.asList(4, 8));
		// numsSet = [4, 8]
		
		System.out.println("numsSet = " + numsSet); // numsSet = [4, 8]

		/*
		 * Get the count of elements present in the HashSet
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		// demoSet = [3, 5, 9]
		int setSize = demoSet.size();

		System.out.println("Size = " + setSize); // Size = 3

		/*
		 * Check if HashSet is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		// demoSet = [3, 5, 9]
		if (demoSet.isEmpty())
			System.out.println("Set is empty !");
		else
			System.out.println("Set is not empty !");

		/*
		 * Check if an object is present the HashSet
		 * 
		 * boolean contains(Object obj) : Declared in the Collection interface. Returns
		 * true if obj is an element of the invoking collection. Otherwise, returns
		 * false.
		 */

		int value = 9;

		// demoSet = [3, 5, 9]
		if (demoSet.contains(value))
			System.out.println("Set contains " + value);
		else
			System.out.println("Set does not contain " + value);

		/*
		 * Clear the HashSet
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		// demoSet = [3, 5, 9]
		demoSet.clear();
		// demoSet = []

		System.out.println("demoSet = " + demoSet); // demoSet = []

		/*
		 * Construct HashSet from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange", "grape" };

		HashSet<String> fruitSet = new HashSet<>();

		Collections.addAll(fruitSet, fruits);

		System.out.println("fruitSet = " + fruitSet); // fruitSet = [banana, orange, apple, grape]

		/*
		 * Construct array from HashSet
		 */

		String fruitArr[] = fruitSet.toArray(new String[fruitSet.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr)); // fruitArr = [banana, orange, apple, grape]

		/*
		 * Iterating over the contents of a HashSet
		 * 
		 * Iterator<E> iterator() : Declared in the Collection interface. Returns an
		 * iterator for the invoking collection.
		 */

		Iterator itr = fruitSet.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		// Iterate using for-each loop

		for (String fruit : fruitSet) {
			System.out.print(fruit + " ");
		}
		
	}

}

