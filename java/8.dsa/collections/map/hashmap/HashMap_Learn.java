
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMap_Learn {

	public static void main(String[] args) {


		Map<Integer, String> studentMap = new HashMap<>();

    // Adding elements to HashMap

		studentMap.put(1, "Naman");
		studentMap.put(2, "Vivek");
		studentMap.put(3, "Payal");

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal}

		Map<Integer, String> newStudents = new HashMap<>();

		newStudents.put(4, "Neha");
		newStudents.put(5, "Anupam");

		studentMap.putAll(newStudents);

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam}

		String existingStudent = studentMap.putIfAbsent(5, "Rohan");

		System.out.println("existingStudent = " + existingStudent);
		// existingStudent = Anupam

		existingStudent = studentMap.putIfAbsent(6, "Sumit");
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam, 6=Sumit}

		System.out.println("existingStudent = " + existingStudent);
		// existingStudent = null

       //  Removing elements from HashMap

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam, 6=Sumit}
		studentMap.remove(4);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam, 6=Sumit}

		studentMap.remove(6, "Sumit");
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}


		// Get values from HashMap

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}
		String studentName = studentMap.get(2);

		System.out.println("studentName = " + studentName);
		// studentName = Vivek

		studentName = studentMap.get(4);

		System.out.println("studentName = " + studentName);
		// studentName = null

      // Check if HashMap contains a key / value

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}

		if (studentMap.containsKey(3))
			System.out.println("Key found");
		else
			System.out.println("Key not found");

		if (studentMap.containsValue("Pankaj"))
			System.out.println("Value found");
		else
			System.out.println("Value not found");

        // Replace key / value in HashMap

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}

		studentMap.replace(3, "Payal", "Sejal");
		// studentMap = {1=Naman, 2=Vivek, 3=Sejal, 5=Anupam}

		String oldName = studentMap.replace(3, "Ronit");

		System.out.println("oldName = " + oldName); // oldName = Sejal

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}

		/*
		 * Get the count of key-value pairs in the HashMap
		 * 
		 * int size() : Declared in the 'Map' interface. Returns the number of key-value
		 * pairs in the map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int mapSize = studentMap.size();

		System.out.println("mapSize = " + mapSize); // mapSize = 4

		/*
		 * Check if HashMap is empty or not
		 * 
		 * boolean isEmpty() : Declared in the 'Map' interface. Returns true if the
		 * invoking map is empty. Otherwise, returns false.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		if (studentMap.isEmpty())
			System.out.println("Map is empty");
		else
			System.out.println("Map is not empty");

		/*
		 * Iterating over HashMap entries
		 * 
		 * Set<Map.Entry<K, V>> entrySet() : Declared in the 'Map' interface. Returns a
		 * Set that contains the entries in the map. The set contains objects of type
		 * Map.Entry, i.e. this method provides a set-view of the invoking map.
		 */

		Set<Map.Entry<Integer, String>> mapSet = studentMap.entrySet();

		for (Map.Entry<Integer, String> kv : mapSet) {
			System.out.print(kv.getKey() + " -> " + kv.getValue() + " ");
		}
		// 1 -> Naman 2 -> Vivek 3 -> Ronit 5 -> Anupam

		System.out.println();

		for (Map.Entry kv : studentMap.entrySet()) {
			System.out.print(kv.getKey() + " -> " + kv.getValue() + " ");
		}
		// 1 -> Naman 2 -> Vivek 3 -> Ronit 5 -> Anupam

		System.out.println();

		/*
		 * Remove all key-value pair from the HashMap
		 * 
		 * void clear() : Declared in the 'Map' interface. Removes all key-value pairs
		 * from the invoking map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		studentMap.clear();
		// studentMap = {}

		System.out.println("studentMap = " + studentMap);

	}

}

