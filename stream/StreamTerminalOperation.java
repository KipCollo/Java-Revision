import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalOperation {
public static void main(String[] args) {
        // Sample data
        List<String> names = Arrays.asList(
            "Reflection", "Collection", "Stream",
            "Structure", "Sorting", "State"
        );

        // forEach: Print each name
        System.out.println("forEach:");
        names.stream().forEach(System.out::println);

        // collect: Collect names starting with 'S' into a list
        List<String> sNames = names.stream()
                                   .filter(name -> name.startsWith("S"))
                                   .collect(Collectors.toList());
        System.out.println("\ncollect (names starting with 'S'):");
        sNames.forEach(System.out::println);

        // reduce: Concatenate all names into a single string
        String concatenatedNames = names.stream().reduce(
            "",
            (partialString, element) -> partialString + " " + element
        );
        System.out.println("\nreduce (concatenated names):");
        System.out.println(concatenatedNames.trim());

        // count: Count the number of names
        long count = names.stream().count();
        System.out.println("\ncount:");
        System.out.println(count);

        // findFirst: Find the first name
        Optional<String> firstName = names.stream().findFirst();
        System.out.println("\nfindFirst:");
        firstName.ifPresent(System.out::println);

        // allMatch: Check if all names start with 'S'
        boolean allStartWithS = names.stream().allMatch(
            name -> name.startsWith("S")
        );
        System.out.println("\nallMatch (all start with 'S'):");
        System.out.println(allStartWithS);

        // anyMatch: Check if any name starts with 'S'
        boolean anyStartWithS = names.stream().anyMatch(
            name -> name.startsWith("S")
        );
        System.out.println("\nanyMatch (any start with 'S'):");
        System.out.println(anyStartWithS);

//         Output

// forEach:
// Reflection
// Collection
// Stream
// Structure
// Sorting
// State

// collect (names starting with 'S'):
// Stream
// Structure
// Sorting
// State

// reduce (concatenated names):
// Reflection Collection Stream Structure So...

// Explanation of the above Program:

// List Creation:

//     The names list is created with sample strings.

// Stream Operations:

//     forEach: Prints each name in the list.
//     collect: Filters names starting with ‘S’ and collects them into a new list.
//     reduce: Concatenates all names into a single string.
//     count: Counts the total number of names.
//     findFirst: Finds and prints the first name in the list.
//     allMatch: Checks if all names start with ‘S’.
//     anyMatch: Checks if any name starts with ‘S’.

// The program prints each name, names starting with ‘S’, concatenated names, the count of names, the first name, whether all names start with ‘S’, and whether any name starts with ‘S’.
// Important Points/Observations of Java Stream

//     A stream consists of a source followed by zero or more intermediate methods combined together (pipelined) and a terminal method to process the objects obtained from the source as per the methods described.
//     Stream is used to compute elements as per the pipelined methods without altering the original value of the object.


    }
}
 

