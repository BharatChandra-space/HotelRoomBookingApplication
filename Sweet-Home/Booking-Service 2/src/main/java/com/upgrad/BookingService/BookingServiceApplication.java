package com.upgrad.BookingService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookingServiceApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(BookingServiceApplication.class, args);
		System.out.println("Amma");
	}

	@Bean public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate(){return new RestTemplate();}

}
