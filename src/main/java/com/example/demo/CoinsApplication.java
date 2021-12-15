package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coins.controller.UserBalanceController;


@SpringBootApplication(scanBasePackages = {"com.coins.beans", "com.coins.repository","com.coins.service"})
@ComponentScan(basePackageClasses = UserBalanceController.class)
@Configuration
@ComponentScan("com.coins.*")
@EnableJpaRepositories(basePackages = {"com.coins.*"})
@EntityScan("com.coins"
		+ ".*")
@EnableAutoConfiguration
public class CoinsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CoinsApplication.class, args);
		
	}

}
