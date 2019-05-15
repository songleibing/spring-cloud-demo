package com.garen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Producter8001Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Producter8001Application.class, args);
	}
}
