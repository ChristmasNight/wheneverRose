package com.study.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.study.core"}) 
public class RoseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RoseApiApplication.class, args);
	}
}
