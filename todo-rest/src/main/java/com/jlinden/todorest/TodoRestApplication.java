package com.jlinden.todorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.jlinden.todorest"})
public class TodoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestApplication.class, args);
	}

}
