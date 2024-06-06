package com.newsgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Entry point for the NewsGenerator Microservice Spring Boot application. This
 * class contains the main method to run the application.
 */
@SpringBootApplication(scanBasePackages = "com.newsgenerator")
@EnableCaching
public class NewsGenerator {

	public static void main(String[] args) {
		SpringApplication.run(NewsGenerator.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
