package com.kipcollo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    // @Value(${name})
    public Prop prop() {
        return new Prop(environment.getProperty("name"));
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    

}
