package com.hz.springboot;


import com.hz.springboot.business.webservice.WeatherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class SpringbootApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

		//WebService的发布地址
		String address = "http://39.108.216.43:7088/weather";
		//发布WebService，WebServiceImpl类是WebServie接口的具体实现类
		Endpoint.publish(address, new WeatherServiceImpl());
		LOGGER.info("使用WebServicePublishServlet发布WeatherServiceImpl成功!");

	}
}
