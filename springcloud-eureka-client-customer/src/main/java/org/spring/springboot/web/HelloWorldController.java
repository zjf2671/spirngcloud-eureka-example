package org.spring.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Spring Boot HelloWorld 案例 
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@RestController
public class HelloWorldController {
	
	 @Autowired
	 private DiscoveryClient discoveryClient;
	 
    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }
    
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
    
}
