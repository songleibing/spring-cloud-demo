package com.garen.demo.service;

import com.garen.demo.fallback.HelloServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-cloud-demo-producter", fallbackFactory = HelloServiceFallbackFactory.class)
public interface HelloService {

    @RequestMapping("/product/hello/{name}")
    String sayHello(@PathVariable("name") String name);
}
