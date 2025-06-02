import java.util.ArrayList;
import java.util.List;

public class ArrayListFromCollection {

    public static void main(String[] args) {
        
        //create arraylist from another collection
        List<Integer> number= new ArrayList<>();
        number.add(1);
        number.add(2);

        List<Integer> number2= new ArrayList<>(number);
        System.out.println(number2);

        //create arraylist from existing collection to new arraylist using addAll method
        List<Integer> nums = new ArrayList<>();
        nums.add(12);
        nums.add(13);

        number.addAll(nums);

    }
}
