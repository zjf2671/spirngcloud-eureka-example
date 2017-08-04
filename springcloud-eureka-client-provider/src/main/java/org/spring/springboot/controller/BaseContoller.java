package org.spring.springboot.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * @Description: 
 * @author harry.zhang
 * @CreateDate:	2017年8月4日
 * @version 1.0
 */
public class BaseContoller {
	
    private final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient discoveryClient;// 激活Eureka中的DiscoveryClient实现
	
    
    public void getServerInfo(){
    	ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();//获取Discoveryclient，打印注册中心的log
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("host:" + serviceInstance.getHost() + ", service id:" + serviceInstance.getServiceId());
        }
    }

}
