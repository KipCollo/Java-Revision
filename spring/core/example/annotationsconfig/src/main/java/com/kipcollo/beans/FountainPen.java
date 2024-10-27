package com.kipcollo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kipcollo.interfaces.Ink;
import com.kipcollo.interfaces.Pen;

@Component
public class FountainPen implements Pen{

    private Ink ink;

    @Autowired
    public FountainPen(final Ink ink){
        this.ink = ink;
    }

    @Override
    public void write() {
        System.out.println("Fountain pen is writing");
    }

}
