package com.jforce.sonproje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.jforce")
@EnableWebMvc
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.jforce.model"})
public class SonprojeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonprojeApplication.class, args);
	}

}
