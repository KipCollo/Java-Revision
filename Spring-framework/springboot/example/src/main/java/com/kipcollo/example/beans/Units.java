package com.kipcollo.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class Units {

    @Value("${name}")
    String name;

    @Value("${age}")
    int age;
    public Units() {
    System.out.println("This is the Subjects class");
    }

    public String getDetails(){
        return name + " " + age;
    }
}
