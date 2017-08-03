package org.spring.springboot.controller;

import org.apache.log4j.Logger;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@RestController
@RequestMapping("cityInfo")
public class CityRestController {

    private final Logger LOGGER = Logger.getLogger(getClass());
	
    @Autowired
    private CityService cityService;
    
    @Autowired
    private DiscoveryClient discoveryClient;//激活Eureka中的DiscoveryClient实现

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
    	
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();//获取Discoveryclient，打印注册中心的log

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("host:" + serviceInstance.getHost() + ", service id:" + serviceInstance.getServiceId());
        }
        
        return cityService.findCityByName(cityName);
    }

}
