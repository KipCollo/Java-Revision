package com.kipcollo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kipcollo.beans.Writer;
import com.kipcollo.config.AppConfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //Spring Config Component Scan
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Writer writer = (Writer)context.getBean(Writer.class);

        writer.write();
        System.out.println(writer);

        Writer writerOne = (Writer)context.getBean(Writer.class);

        writerOne.write();
        System.out.println(writerOne);//scope

        // //Xml Component Scan
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        // Writer writerXml = (Writer)ctx.getBean(Writer.class);

        // writerXml.write();
    


    }
}
