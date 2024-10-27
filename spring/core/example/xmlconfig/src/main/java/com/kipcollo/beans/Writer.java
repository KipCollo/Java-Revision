package com.kipcollo.beans;

import com.kipcollo.interfaces.Pen;

public class Writer {

    private Pen pen;

    public Writer(Pen pen) {
        this.pen = pen;
    }

    public void write() {
        pen.write();
    }
    

}
