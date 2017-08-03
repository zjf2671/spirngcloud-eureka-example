package org.spring.springboot.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 调用运程服务接口
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@FeignClient("city-service")
public interface CityInfoClient {

    @RequestMapping(value = "cityInfo/api/city", method = RequestMethod.GET)
    public String findCityInfos(@RequestParam(value = "cityName", required = true) String cityName);

}
