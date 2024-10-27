package com.kipcollo.beans;

import com.kipcollo.interfaces.Ink;
import com.kipcollo.interfaces.Pen;

public class FountainPen implements Pen{

    private Ink ink;

    public FountainPen(final Ink ink){
        this.ink = ink;
    }

    @Override
    public void write() {
        System.out.println("Fountain pen is writing");
    }

}
