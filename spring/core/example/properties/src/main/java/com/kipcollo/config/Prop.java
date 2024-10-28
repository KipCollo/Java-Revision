package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Prop {
 
    @Value("${name}")
    String name;

    @Value("${password}")
    String password;

    public Prop(String name,String password){
        this.name=name;
        this.password=password;

        System.out.println(name + password);
    }

}
