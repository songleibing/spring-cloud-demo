package com.garen.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-demo-producter")
public interface HelloService {

    @RequestMapping("/product/hello/{name}")
    String sayHello(@PathVariable("name") String name);
}
