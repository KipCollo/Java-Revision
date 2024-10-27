package introduction.enumaration;

public class Main {
    public static void main(String[] args) {
        
        Days today = Days.MONDAY;
        System.out.println(today);
        System.out.println(today.ordinal()); // get index of constants

        Days[] value = Days.values();// Returns array of constants defined
        System.out.println(value[1]);

        for (Days days : value) {
            System.out.println(days);
        }

       
    }

}
