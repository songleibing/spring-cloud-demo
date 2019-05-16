package com.garen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/info")
public class InfoController {

    @Autowired
    private EurekaInstanceConfigBean eurekaInstance;

    @GetMapping
    public String info() {
        return eurekaInstance.getInstanceId();
    }

}
