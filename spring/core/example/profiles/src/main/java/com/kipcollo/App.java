package com.kipcollo;

import java.io.ObjectInputFilter.Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kipcollo.beans.Prop;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Start");
        System.setProperty("spring.profiles.active", "dev");
        //System.setProperty("spring.profiles.active", "prod");

        ApplicationContext  context = new AnnotationConfigApplicationContext(Config.class);
        Prop prop= (Prop)context.getBean(Prop.class);
    }
}
