package introduction.arrays;

import java.util.Arrays;

public class Array1 {

	public static void main (String[] args) 
	{		 
	// declares an Array of integers.
	int[] arr;
		
	// allocating memory for 5 integers.
	arr = new int[5];
	String[] cars= {"Volvo", "Mercedes"};
		
	// initialize the elements of the array
	arr[0] = 10;
	arr[1] = 20;
	arr[2] = 30;
	arr[3] = 40;
	arr[4] = 50;
		
	// accessing element at a position

	System.out.println(arr[1]);
	
	// accessing the elements of the specified array
	for (int i = 0; i < arr.length; i++)
		System.out.println("index " + i + 
									" : "+ arr[i]);		 
	
	// Print all the array elements using for-each
	System.out.println("Print using foreach loop");
    for (int element: arr)
        System.out.println(element);

	// Accessing arrays using Array class
	System.out.println(Arrays.toString(cars));
    }
}
