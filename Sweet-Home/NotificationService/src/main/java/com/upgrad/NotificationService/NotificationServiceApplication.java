package com.upgrad.NotificationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(NotificationServiceApplication.class, args);
		System.out.println("Bunny");
	}

}
