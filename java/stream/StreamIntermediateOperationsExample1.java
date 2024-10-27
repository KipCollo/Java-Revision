import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamIntermediateOperationsExample1 {
public static void main(String[] args) {
        // List of lists of names
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("Reflection", "Collection", "Stream"),
            Arrays.asList("Structure", "State", "Flow"),
            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
            .flatMap(List::stream)               // Flatten the list of lists into a single stream
            .filter(s -> s.startsWith("S"))      // Filter elements starting with "S"
            .map(String::toUpperCase)            // Transform each element to uppercase
            .distinct()                          // Remove duplicate elements
            .sorted()                            // Sort elements
            .peek(s -> intermediateResults.add(s)) // Perform an action (add to set) on each element
            .collect(Collectors.toList());       // Collect the final result into a list

        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("Final Result:");
        result.forEach(System.out::println);



// Output:

// STRUCTURE
// STREAM
// STATE
// SORTING
// Final Result:
// SORTING
// STATE
// STREAM
// STRUCTURE

// Explanation of the above Program:

// List of Lists Creation:

//     The listOfLists is created as a list containing other lists of strings.

// Stream Operations:

//     flatMap(List::stream): Flattens the nested lists into a single stream of strings.
//     filter(s -> s.startsWith("S")): Filters the strings to only include those that start with “S”.
//     map(String::toUpperCase): Converts each string in the stream to uppercase.
//     distinct(): Removes any duplicate strings.
//     sorted(): Sorts the resulting strings alphabetically.
//     peek(...): Adds each processed element to the intermediateResults set for intermediate inspection.
//     collect(Collectors.toList()): Collects the final processed strings into a list called result.

    }
}
