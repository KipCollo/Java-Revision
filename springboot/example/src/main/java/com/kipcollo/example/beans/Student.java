package com.kipcollo.example.beans;

import org.springframework.stereotype.Controller;

@Controller
public class Student {


    Units units;

    public Student(Units units) {
        this.units=units;
        System.out.println("This is the Student class");
    }
}
