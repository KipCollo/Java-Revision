import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
public class Main {

public static void main(String[] args) {
    

    int[] numbers = {1,2,3,4,5};// arrays doesn't have a stream instead Arrays from java.util is used.
     Arrays.stream(numbers)
             .limit(3)
            .forEach(n->System.out.println(n));//Takes a consumer i.e doen't have return type.


    Stream.of(1,22,4);// creates a stream of values supplied
    Stream.generate(()->Math.random());// It's genrated ahead of time i.e lazy evaluation
    Stream.iterate(1,n->n +1);// creates a stream of numbers by iterating

    List<Integer> students = Arrays.asList(1,2,3,4,5,6,7,8);

    Stream<Integer> std=students.stream()
            .filter(n -> n%2==0)
            .map(n -> n*2);
    std.forEach(n -> System.out.println(n));
}


}
