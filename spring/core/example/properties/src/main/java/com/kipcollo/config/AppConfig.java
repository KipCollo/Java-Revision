package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:properties/application.properties")
@ComponentScan("com.kipcollo.*")
public class AppConfig {

    @Autowired
    Environment environment;

    // @Bean
    // public Prop prop() {
    //     Prop prop =new Prop();
    //     environment.getClass().getName();
    //     prop.getName(environment.getProperty("name"));
    //     prop.getPassword(environment.getProperty("password"));
    //     return prop;
    // }

    @Bean
    @Autowired
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    

}
