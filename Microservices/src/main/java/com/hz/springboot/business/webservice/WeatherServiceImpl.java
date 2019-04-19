package com.hz.springboot.business.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;

/**
 * @Auther: huangzhuo
 * @Date: 2019/4/16 20:15
 * @Description:
 */
@WebService(endpointInterface = "com.hz.springboot.business.webservice.IWeatherService")
public class WeatherServiceImpl implements IWeatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Override
    public String query(String str) {
        LOGGER.info(str);
        return str;
    }
}
