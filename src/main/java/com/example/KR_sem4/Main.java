package com.example.KR_sem4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
//		try {
//			System.out.println("Начало задержки...");
//			Thread.sleep(50000);
//			System.out.println("Задержка выполнена. Запуск приложения...");
//			SpringApplication.run(Main.class, args);
//		} catch (InterruptedException e) {
//			Thread.currentThread().interrupt();
//			System.err.println("Прерывание задержки: " + e.getMessage());
//		}
	}

}
