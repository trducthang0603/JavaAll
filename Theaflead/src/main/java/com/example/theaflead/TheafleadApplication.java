package com.example.theaflead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TheafleadApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TheafleadApplication.class, args);
	}

}