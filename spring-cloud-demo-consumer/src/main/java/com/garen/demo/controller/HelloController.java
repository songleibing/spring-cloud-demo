package com.garen.demo.controller;

import com.garen.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
    }

}
