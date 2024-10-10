package introduction.controls.conditionals.switchstmt;

public class Switch {


    public static void main(String[] args) {
        int number =7;

        switch(number){
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            default -> System.out.println("Friday");
        }
    }
   

}
