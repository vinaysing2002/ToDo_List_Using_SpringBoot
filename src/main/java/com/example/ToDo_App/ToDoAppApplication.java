package com.example.ToDo_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
		System.out.println("service running..");
	}

}
//spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
//spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//spring.jpa.show-sql=true