package com.kipcollo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.kipcollo.beans")
public class Config {

    @Bean
    @Profile("dev")
    public PropertySourcesPlaceholderConfigurer devSourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer =new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("dev.properties"));
        return  placeholderConfigurer;
    }

    @Bean
    @Profile("test")
    public PropertySourcesPlaceholderConfigurer testSourcesPlaceholderConfigurer() {
         PropertySourcesPlaceholderConfigurer placeholderConfigurer= new PropertySourcesPlaceholderConfigurer();
         placeholderConfigurer.setLocation(new ClassPathResource("test.properties"));
         return placeholderConfigurer;
    }

    @Bean
    @Profile("prod")
    public PropertySourcesPlaceholderConfigurer prodSourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer= new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("prod.properties"));
        return placeholderConfigurer;
    }

}
