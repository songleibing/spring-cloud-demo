package com.garen.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product/hello")
@RestController
public class HelloController {

    @RequestMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return String.format("Hello %s", name);
    }
}
