package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 城市业务逻辑实现类 
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

	@Override
	public List<City> findCityList(City city) {
		return cityDao.findCityList(city);
	}

}
