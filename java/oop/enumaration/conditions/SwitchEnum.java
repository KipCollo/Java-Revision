package introduction.enumaration.conditions;

import introduction.enumaration.Days;

public class SwitchEnum {

   
    public static void main(String[] args) {
        Days day =Days.WEDNESDAY;

        switch (day) {
            case MONDAY:
                System.out.println("Monday");
                break;
            case TUESDAY:
                System.out.println("Monday");
                break;
            default:
                System.out.println("Wednesday");
                break;
        }
    }

    
}
