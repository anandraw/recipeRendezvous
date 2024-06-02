package com.anand;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecipeRendezvousApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeRendezvousApplication.class, args);
		System.out.println("Appliation Started...Anand");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
