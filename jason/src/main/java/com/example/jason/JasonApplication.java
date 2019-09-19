package com.example.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller")
public class JasonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasonApplication.class, args);
	}

}
