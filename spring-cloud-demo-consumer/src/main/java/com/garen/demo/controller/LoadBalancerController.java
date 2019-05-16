package com.garen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loadbalancer")
public class LoadBalancerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/info")
    public String info() {
        ServiceInstance instance = loadBalancerClient.choose("SPRING-CLOUD-DEMO-PRODUCTER");
        return instance.getUri() + "   " + instance.getHost() + "    " + instance.getPort();
    }
}
