import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayListImplementation {

	public static void main(String[] args) {

	//constructor
	 List<Integer> numList = new ArrayList<>();//Creates empty list with initial capacity of ten
    List<Integer> newList1 = new ArrayList<>(50);//Creates empty list with initial capacity specified.
    List<Integer> newList2 = new ArrayList<>();//Constructs a list containing the elements of the specified collection

	//Methods
     //Adding elements to ArrayList
		numList.add(7); // numList = [7]
		numList.add(5); // numList = [7, 5]
		numList.add(1, 3); // numList = [7, 3, 5]

		List<Integer> nums = new ArrayList<>(Arrays.asList(6, 3, 1));
		numList.addAll(nums); // numList = [7, 3, 5, 6, 3, 1]
 		nums = new ArrayList<>(Arrays.asList(4, 7));
		numList.addAll(4, nums); // numList = [7, 3, 5, 6, 4, 7, 3, 1]

		System.out.println("numList = " + numList); // numList = [7, 3, 5, 6, 4, 7, 3, 1]


	 //Removing elements from ArrayList
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]
		numList.remove(Integer.valueOf(3)); // numList = [7, 5, 6, 4, 7, 3, 1]
		numList.remove(0);// numList = [5, 6, 4, 7, 3, 1]
		numList.remove(7);//numList = [5, 6, 4, 3, 1]
		nums = new ArrayList<>(Arrays.asList(6, 7));

		// removes all occurrences of each element of nums from numList
		numList.removeAll(nums);// numList = [5, 4, 3, 1]

		int removedElement = numList.remove(1);
		System.out.println("removedElement = " + removedElement); // removedElement = 4

		System.out.println("numList = " + numList);// numList = [5, 3, 1]

		numList.addAll(Arrays.asList(4, 7, 3, 1, 5));// numList = [5, 3, 1, 4, 7, 3, 1, 5]
		nums.addAll(Arrays.asList(5, 1));// nums = [6, 7, 5, 1]

		numList.retainAll(nums); // Elements [3, 4] are removed from numList
		// numList = [5, 1, 7, 1, 5]

		System.out.println("numList = " + numList);// numList = [5, 1, 7, 1, 5]

	 //Check if ArrayList contains an object
		int value = 5;

		// numList = [5, 1, 7, 1, 5]
		if (numList.contains(value))
			System.out.println("numList contains " + value);
		else
			System.out.println("numList does not contain " + value);

		nums = new ArrayList<>(Arrays.asList(5, 7));

		// numList = [5, 1, 7, 1, 5]
		if (numList.containsAll(nums))
			System.out.println("numList contains all elements of nums");
		else
			System.out.println("numList does not contain all elements of nums");

		
	 // Get the element at an index in ArrayList
       // numList = [5, 1, 7, 1, 5]
		int element = numList.get(2);
		System.out.println("element = " + element); // element = 7

	 // Get the index of an element in ArrayList
		// numList = [5, 1, 7, 1, 5]
		int lastIndex = numList.lastIndexOf(5);
		System.out.println("lastIndex = " + lastIndex); // lastIndex = 4

		
	 // Set the element at an index in ArrayList
		// numList = [5, 1, 7, 1, 5]
		int oldValue = numList.set(3, 9);
		System.out.println("oldValue = " + oldValue); // oldValue = 1
		System.out.println("numList = " + numList); // numList = [5, 1, 7, 9, 5]

	
	 // Check if ArrayList is empty or not
		// numList = [5, 1, 7, 9, 5]
		if (numList.isEmpty())
			System.out.println("ArrayList is empty");
		else
			System.out.println("ArrayList is not empty");

	 //Get the count of elements present in the ArrayList
		// numList = [5, 1, 7, 9, 5]
		int listSize = numList.size();
		System.out.println("Size = " + listSize); // Size = 5

	 // Get sub-list from an ArrayList
		// numList = [5, 1, 7, 9, 5]
		List<Integer> subArrayList = new ArrayList<Integer>();
		subArrayList = numList.subList(1, 4);

		System.out.println("subArrayList = " + subArrayList); // subArrayList = [1, 7, 9]

     // Clear the ArrayList
		// numList = [5, 1, 7, 9, 5]
		numList.clear();
		System.out.println("numList = " + numList); // numList = []


		/*
		 * Construct ArrayList from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange", "grape" };

		List<String> fruitList = new ArrayList<>();

		Collections.addAll(fruitList, fruits);

		System.out.println("fruitList = " + fruitList); // fruitList = [apple, grape, banana, orange, grape]

		/*
		 * Construct array from ArrayList
		 */

		String fruitArr[] = fruitList.toArray(new String[fruitList.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr)); // fruitArr = [apple, grape, banana, orange,
																		// grape]

	 // Iterating over the contents of a ArrayList
	
		// fruitList = [apple, grape, banana, orange, grape]
		Iterator itr = fruitList.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		// Using for loop
		for(int i=0;i<=fruitList.size();i++){
			System.out.println(fruitList.get(i));
		}

		// Iterate using for-each loop
		  // fruitList = [apple, grape, banana, orange, grape]
		for (String fruit : fruitList) {
			System.out.print(fruit + " ");
		}

		System.out.println();

		 // using stream and lambda expression
		 fruitList.stream()
		 			.forEach(e->System.out.println(e));
					
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

	}

}
