package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.vo.CityVO;

public interface CityService {
	
	public CityVO findCityInfos(String cityName);
	
	public List<CityVO> findCityList(CityVO cityVO);

}
