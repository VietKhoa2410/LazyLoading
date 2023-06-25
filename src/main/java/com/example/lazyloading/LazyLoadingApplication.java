package com.example.lazyloading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LazyLoadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazyLoadingApplication.class, args);
	}

}
