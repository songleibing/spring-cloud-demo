package com.garen.demo.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
	
	@Autowired
	private DiscoveryClient client;
	
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
