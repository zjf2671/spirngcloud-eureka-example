package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.client.CityInfoClient;
import org.spring.springboot.service.CityService;
import org.spring.springboot.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityInfoClient cityInfoClient;

	public CityVO findCityInfos(String cityName) {
		return cityInfoClient.findCityInfos(cityName);
	}
	
	public List<CityVO> findCityList(CityVO cityVO){
		return cityInfoClient.finCityList(cityVO);
	}

}
