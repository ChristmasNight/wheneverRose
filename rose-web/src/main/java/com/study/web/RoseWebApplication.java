package com.study.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.study.core"})
@EnableJpaRepositories(basePackages = {"com.study.core"})
public class RoseWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(RoseWebApplication.class, args);
	}
}
