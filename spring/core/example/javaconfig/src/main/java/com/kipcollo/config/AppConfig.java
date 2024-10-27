package com.kipcollo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kipcollo.beans.BlackInk;
import com.kipcollo.beans.FountainPen;
import com.kipcollo.beans.Writer;
import com.kipcollo.interfaces.Ink;
import com.kipcollo.interfaces.Pen;

@Configuration
@ComponentScan(basePackages = "com.kipcollo.lazy")
public class AppConfig {

    // @Bean
    // @Scope("singleton")
    // public Writer writer(Pen pen) {
    //     return new Writer(pen);
    // }

    // @Bean
    // public Pen fountainPen(Ink ink) {
    //     return new FountainPen(ink);
    // }

    // @Bean
    // public Ink blackInk() {
    //     return new BlackInk();
    // }


   
}
