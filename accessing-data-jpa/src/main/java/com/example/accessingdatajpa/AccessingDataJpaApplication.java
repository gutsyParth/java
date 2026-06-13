package com.example.accessingdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				AccessingDataJpaApplication.class,
				args
		);
	}

	@Bean
	public CommandLineRunner demo(
			CustomerRepository repository) {

		return args -> {

			repository.save(
					new Customer("Parth", "Yadav"));

			repository.save(
					new Customer("John", "Doe"));
		};
	}
}