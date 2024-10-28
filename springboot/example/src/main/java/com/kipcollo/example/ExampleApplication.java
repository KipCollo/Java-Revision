package com.kipcollo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kipcollo.example.beans.Student;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt=SpringApplication.run(ExampleApplication.class, args);
		Student std =cxt.getBean(Student.class);

		String[] beans=cxt.getBeanDefinitionNames();
		for(String bean:beans) {
			System.out.println(bean);
		}

		System.out.println(cxt.getBeanDefinitionCount());
	}

}
