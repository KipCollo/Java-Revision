import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(5);
        nums.add(2);

        Collections.sort(nums);// ascending
        System.out.println(nums);

        Collections.reverse(nums);// Descending
        System.out.println(nums);

        //using comparator
        List<Student> students=new ArrayList<>();
        students.add(new  Student(1,"coll", 70));
        students.add(new  Student(2,"col", 29));
        students.add(new  Student(3,"cols", 30));

        Collections.sort(students, new StudentSort());
        System.out.println(students);

        //using lambda expression
        Collections.sort(students,()-> (Student one,Student two){
                return one.getAge() - two.getAge();
            }
        );
    }
}

class StudentSort implements Comparator<Student>{

    @Override
    public int compare(Student t, Student t1) {
        return t.getAge() - t.getAge();
    }
    
}
