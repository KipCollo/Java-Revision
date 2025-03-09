package com.kipcollo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kipcollo.config.AppConfig;
import com.kipcollo.config.Prop;

public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Prop prop =context.getBean(Prop.class);
        System.out.println(prop);
    }
}
