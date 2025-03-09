package com.kipcollo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kipcollo.beans.Writer;
import com.kipcollo.config.AppConfig;
import com.kipcollo.lazy.A;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Writer writer = (Writer)context.getBean(Writer.class);
        writer.write();
        System.out.println(writer);
        
        Writer writerOne = (Writer)context.getBean(Writer.class);
        writerOne.write();
        System.out.println(writerOne);

        ((AnnotationConfigApplicationContext) context).close();

        ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
        Writer writerOpen = (Writer)cxt.getBean(Writer.class);
        writerOpen.write();
        System.out.println(writerOpen);

        ApplicationContext lazy = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = (A)lazy.getBean(A.class);
        System.out.println(a);
        
    }
}
