package com.example.shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}
}
