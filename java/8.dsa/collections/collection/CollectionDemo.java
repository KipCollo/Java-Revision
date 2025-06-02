import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

  public static void main(String[] args){

    Collection<String> cars= new ArrayList<>();
    cars.add("BMW");
    cars.add("Mercedes");// adding element to collection

    System.out.println(cars);

    cars.remove("BMW");// removing element from collection
    System.out.println(cars);

    cars.contains("Mercedes");// check if collection contains a value

    cars.forEach(element->System.out.println(element));

    

}
}
