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
}
}