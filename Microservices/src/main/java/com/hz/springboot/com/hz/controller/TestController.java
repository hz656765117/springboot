package com.hz.springboot.com.hz.controller;

import com.hz.springboot.com.hz.base.quartz.ScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger LOGGER =  LoggerFactory.getLogger(TestController.class);
    @RequestMapping("test")
    public String getSomething(){
        LOGGER.debug("debugdebugdebugtest1111123434");
        LOGGER.info("infoinfoinfotest1111123434");
        LOGGER.error("errorerrorerrortest1111123434");
        LOGGER.warn("warnwarnwarntest1warnwarn111123434");

        return "test111";
    }


}
