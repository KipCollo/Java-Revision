package introduction.enumaration.conditions;

import introduction.enumaration.Days;

public class IfEnum{


    public static void main(String[] args) {
        Days day = Days.MONDAY;

        if (day == Days.MONDAY)
         System.out.println("Monday");
             
        else if (day == Days.TUESDAY)
         System.out.println("Tuesday");
         
        else 
         System.out.println("Wednesday");
    }
  
    
}
