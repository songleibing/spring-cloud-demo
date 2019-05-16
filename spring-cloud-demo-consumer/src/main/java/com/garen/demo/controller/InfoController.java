package com.garen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/info")
public class InfoController {
    private static final String BASE_URL = "http://SPRING-CLOUD-DEMO-PRODUCTER";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String info() {
        return restTemplate.getForObject(BASE_URL + "/product/info", String.class);
    }
}
