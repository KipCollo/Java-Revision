package com.kipcollo.beans;

import com.kipcollo.interfaces.Ink;
import org.springframework.stereotype.Component;

@Component
public class BlackInk implements Ink {

    public BlackInk(){
        System.out.println("Black Ink...");
    }

    @Override
    public String getInkColor() {
        return "Black";
    }


   

}
