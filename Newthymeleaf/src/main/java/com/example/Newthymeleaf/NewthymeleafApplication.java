package com.example.Newthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewthymeleafApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(NewthymeleafApplication.class, args);
//		DatabaseConnector databaseConnector = context.getBean(DatabaseConnector.class);
//		databaseConnector.connect();
	}

}
