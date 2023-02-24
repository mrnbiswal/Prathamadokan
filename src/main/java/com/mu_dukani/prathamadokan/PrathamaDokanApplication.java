package com.mu_dukani.prathamadokan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mu_dukani")
public class PrathamaDokanApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PrathamaDokanApplication.class);
		application.run(args);

	}

}
