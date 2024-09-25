import java.util.ArrayList;
import java.util.List;

public class ArrayListImplementation{

public static void main(String[] args) {
    
    //constructor

    List<Integer> newList = new ArrayList<>();//Creates empty list with initial capacity of ten
    List<Integer> newList1 = new ArrayList<>(50);//Creates empty list with initial capacity specified.
    List<Integer> newList2 = new ArrayList<>();//Constructs a list containing the elements of the specified collection

    //Methods

    //Adding Elements
    newList.add(2); //  Appends the element to the end of this list
    newList1.add(0,3 ); //Inserts the element at the specified position (index) in this list.
    List<Integer> nums = new ArrayList<>(Arrays.asList(6, 3, 1));

    newList.addAll(nums);
    // numList = [7, 3, 5, 6, 3, 1]

    nums = new ArrayList<>(Arrays.asList(4, 7));

    newList.addAll(4, nums);
    // numList = [7, 3, 5, 6, 4, 7, 3, 1]

    System.out.println("numList = " + newList);
    // numList = [7, 3, 5, 6, 4, 7, 3, 1]

    		// numList = [7, 3, 5, 6, 4, 7, 3, 1]
		numList.remove(Integer.valueOf(3));
		// numList = [7, 5, 6, 4, 7, 3, 1]

		nums = new ArrayList<>(Arrays.asList(6, 7));

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
}
}