package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.City;

/**
 * @Description: 城市业务逻辑接口类 
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

	List<City> findCityList(City city);
}
