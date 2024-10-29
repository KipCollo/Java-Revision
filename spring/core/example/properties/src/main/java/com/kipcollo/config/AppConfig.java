package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@PropertySource("classpath:app.properties")
@Configuration
@ComponentScan("com.kipcollo")
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    public Prop prop() {
        Prop prop =new Prop();
        prop.setName(environment.getProperty("name"));
        prop.setPassword(environment.getProperty("password"));
        return prop;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    

}
