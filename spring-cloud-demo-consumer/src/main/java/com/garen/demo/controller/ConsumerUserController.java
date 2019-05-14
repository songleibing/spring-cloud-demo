package com.garen.demo.controller;

import com.garen.demo.domain.User;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ConsumerUserController {

    private static final String PRODUCT_USER_URL = "http://localhost:8082/product/user";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping
    public boolean add(@RequestBody User user) {
        return user != null && restTemplate.postForObject(URI.create(PRODUCT_USER_URL), user, Boolean.class);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        if (id != null) {
            restTemplate.delete(PRODUCT_USER_URL + "/{id}", ImmutableMap.of("id", id));
        }
        return Boolean.TRUE;
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        if (user != null && user.getId() != null) {
            restTemplate.put(URI.create(PRODUCT_USER_URL), user);
        }
        return Boolean.TRUE;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        if (id != null) {
            return restTemplate.getForObject(PRODUCT_USER_URL + "/{id}", User.class, ImmutableMap.of("id", id));
        } else {
            return null;
        }
    }

    @GetMapping
    public List list() {
        return restTemplate.getForObject(PRODUCT_USER_URL, ArrayList.class);
    }
}
