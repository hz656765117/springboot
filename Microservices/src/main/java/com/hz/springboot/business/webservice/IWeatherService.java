package com.hz.springboot.business.webservice;

import javax.jws.WebService;

/**
 * @Auther: huangzhuo
 * @Date: 2019/4/16 20:13
 * @Description:
 */
@WebService
public interface IWeatherService {
    String query(String str);
}
