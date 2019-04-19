package com.hz.springboot.business.webservice;

import javax.jws.WebService;

/**
 * @Auther: huangzhuo
 * @Date: 2019/4/16 20:15
 * @Description:
 */
@WebService(endpointInterface = "com.hz.springboot.business.webservice.IWeatherService")
public class WeatherServiceImpl implements IWeatherService {

    @Override
    public String query(String str) {
        System.out.println(str);
        String result = "hello world";
        return result;
    }
}
