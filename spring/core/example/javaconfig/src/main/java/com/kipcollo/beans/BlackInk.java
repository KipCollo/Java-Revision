package com.kipcollo.beans;

import com.kipcollo.interfaces.Ink;

public class BlackInk implements Ink {

    public BlackInk(){
        System.out.println("Black Ink...");
    }

    @Override
    public String getInkColor() {
        return "Black";
    }


   

}
