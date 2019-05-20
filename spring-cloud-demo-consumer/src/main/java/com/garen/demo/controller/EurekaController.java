package com.garen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EurekaController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/info")
    public String producterInfo() {
        ServiceInstance instance = loadBalancerClient.choose("SPRING-CLOUD-DEMO-PRODUCTER");
        return instance.getUri() + "   " + instance.getHost() + "    " + instance.getPort();
    }

    @GetMapping
    public Map<String, List<ServiceInstance>> info() {
        Map<String, List<ServiceInstance>> resultMap = new HashMap<>();
        List<String> services = client.getServices();
        for (String service : services) {
            resultMap.put(service, client.getInstances(service));
        }
        return resultMap;
    }
}
