import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

public static void main(String[] args) {
    

    int[] numbers = {1,2,3,4,5};// arrays doesn't have a stream instead Arrays from java.util is used.
     Arrays.stream(numbers)
            .forEach(n->System.out.println(n));//Takes a consumer i.e doen't have return type.


    Stream.of(1,22,4);// creates a stream of values supplied
    Stream.generate(()->Math.random());// It's genrated ahead of time i.e lazy evaluation
    Stream.iterate(1,n->n +1);// creates a stream of numbers by iterating
}


}
