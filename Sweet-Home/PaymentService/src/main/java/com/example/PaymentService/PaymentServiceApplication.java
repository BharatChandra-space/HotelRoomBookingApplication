package com.example.PaymentService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(PaymentServiceApplication.class, args);
		System.out.println("Chelli");
	}
	@Bean public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
