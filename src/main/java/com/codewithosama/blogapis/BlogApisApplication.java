package com.codewithosama.blogapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.codewithosama.blogapis.controllers.UserController;

@SpringBootApplication
@EntityScan("com.codewithosama.blogapis.entities")
@EnableJpaRepositories("com.codewithosama.blogapis.repositories")
@ComponentScan("com.codewithosama.blogapis.services")
@ComponentScan(basePackageClasses = UserController.class)
public class BlogApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApisApplication.class, args);
	}

}
