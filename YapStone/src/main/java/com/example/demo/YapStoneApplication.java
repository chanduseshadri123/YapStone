package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller", "service"})
public class YapStoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(YapStoneApplication.class, args);
	}

}
