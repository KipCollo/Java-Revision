package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Prop {
 
    @Value("{name}")
    String name;

    @Value("{password}")
    String password;


    public String getName(String name) {
        return this.name;
    }

    public String getPassword(String password) {
        return this.password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prop{");
        sb.append("name=").append(this.name);
        sb.append(", password=").append(this.password);
        sb.append('}');
        return sb.toString();
    }

}
