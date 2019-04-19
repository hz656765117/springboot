package com.hz.springboot.business.webservice;

import com.hz.springboot.SpringbootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

/**
 * @Auther: huangzhuo
 * @Date: 2019/4/19 11:55
 * @Description:
 */
@Component
public class PublishService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);

    @PostConstruct
    public  void initService(){
        //WebService的发布地址
        String address = "http://39.108.216.43:7088/weather";
        //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address, new WeatherServiceImpl());
        LOGGER.info("使用WebServicePublishServlet发布WeatherServiceImpl成功!");
    }
}
