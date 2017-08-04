package org.spring.springboot.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.spring.springboot.service.CityService;
import org.spring.springboot.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @Description: client controller
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@RestController
@RequestMapping("city")
public class CityInfoController {

    private static final Logger LOGGER = Logger.getLogger(CityInfoController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value="城市信息", notes="")
    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public ResponseEntity<CityVO> findCityInfos(String cityName) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.info("find CityInfo");
            }
            CityVO result = cityService.findCityInfos(cityName);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (Exception e) {
            LOGGER.error("get CityInfo is failed!" + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    @ApiOperation(value="城市列表", notes="")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<CityVO>> findCityList(CityVO cityVO) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.info("find CityInfo");
            }
            List<CityVO> result = cityService.findCityList(cityVO);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (Exception e) {
            LOGGER.error("get CityInfo is failed!" + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}