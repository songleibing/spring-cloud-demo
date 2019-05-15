package com.garen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducterApplication {
	
	public static void main(String[] args) {
		System.setProperty("server.port", String.valueOf(new Random().nextInt(100000)));
		SpringApplication.run(ProducterApplication.class, args);
	}
}
