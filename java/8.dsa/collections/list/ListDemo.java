import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        
        List<Integer> num= new ArrayList<>();

        //allows duplicate
        num.add(12);
        num.add(13);
        num.add(12);

        System.out.println(num); //{12,13,12}

        // Allows null elements
        num.add(null);
        num.add(null);

        System.out.println(num);//{12,13,12,null,null}

        //insertion order
        List<String> names= new ArrayList<>();
        names.add("name1");
        names.add("name3");
        names.add("name2");

        System.out.println(names);//{name1,name3,name2}

        //accesing elements
        System.out.println(num.get(0));//acess through index

    }
}
