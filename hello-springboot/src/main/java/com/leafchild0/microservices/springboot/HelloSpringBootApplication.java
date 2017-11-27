package com.leafchild0.microservices.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author victor
 * @date 11/27/17
 */
@SpringBootApplication
@EnableConfigurationProperties
public class HelloSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}
}
