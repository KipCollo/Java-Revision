package introduction.enumaration.conditions;

import introduction.enumaration.Days;

public class Switch {

    Days day =Days.MONDAY;

    switch(day)
    {
        case MONDAY:
            System.out.println("Monday");
            break;

        case TUESDAY:
            System.out.println("Tuesday");
            break;
        
        default:
            System.out.println("Wednesady");
            break;
    }
}
