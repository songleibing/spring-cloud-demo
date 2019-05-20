package com.garen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Random;

@EnableDiscoveryClient
@SpringBootApplication
public class ProducterApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", randomPort());
        SpringApplication.run(ProducterApplication.class, args);
    }

    private static String randomPort() {
        while (true) {
            int port = new Random().nextInt(100000);
            if (port >= 30000 && port <= 40000) {
                return String.valueOf(port);
            }
        }
    }
}
