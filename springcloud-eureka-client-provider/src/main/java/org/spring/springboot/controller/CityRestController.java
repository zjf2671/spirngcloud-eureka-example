package org.spring.springboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: city服务端接口
 * @author harry.zhang
 * @CreateDate: 2017年8月3日
 * @version 1.0
 */
@RestController
@RequestMapping("cityInfo")
public class CityRestController extends BaseContoller {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {

		return cityService.findCityByName(cityName);
	}

	@RequestMapping(value = "/api/cityList", method = RequestMethod.POST)
	public List<City> findCityList(@RequestBody City city) {
		getServerInfo();
		return cityService.findCityList(city);
		
	}

}
