package org.spring.springboot.web;

import org.apache.log4j.Logger;
import org.spring.springboot.client.CityInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @Description: client controller
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@RestController
@RequestMapping("cityInfo")
public class CityInfoController {

    private static final Logger LOGGER = Logger.getLogger(CityInfoController.class);

    @Autowired
    private CityInfoClient cityInfoClient;

    @ApiOperation(value="城市节点列表", notes="")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> findCityInfos(@RequestParam(value = "cityName", required = true) String cityName) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.info("find CityInfo");
            }
            String result = cityInfoClient.findCityInfos(cityName);
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