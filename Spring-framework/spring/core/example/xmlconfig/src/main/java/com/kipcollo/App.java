package com.kipcollo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kipcollo.beans.Writer;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Writer writer = (Writer)context.getBean("writer");

        writer.write();

        context.getBean("bmw");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
