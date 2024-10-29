package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Prop {
 
    @Value("${name}")
    String name;

    @Value("${password}")
    String password;

    public void setName(String name) {
        this.name=name;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prop{");
        sb.append("name=").append(name);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }


}
