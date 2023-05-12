package com.narayanjoshi.lbu.sesc.studentportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * This is the main entry point of application which will be run
 */
@SpringBootApplication
@EnableMongoRepositories
public class StudentPortalApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentPortalApplicationRunner.class, args);
	}

}
