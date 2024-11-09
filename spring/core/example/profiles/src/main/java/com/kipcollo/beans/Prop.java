package com.kipcollo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Prop {

    @Value("${app.name}")
    String name;

    public Prop(String name) {
        this.name = name;
    }

}
