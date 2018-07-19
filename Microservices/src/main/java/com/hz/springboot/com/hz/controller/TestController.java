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


    @RequestMapping("test1")
    public String getSomething1(){
        LOGGER.debug("aaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("aaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("aaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("aaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");

        return "test111";
    }

    @RequestMapping({"test2"})
    public String getSomething2() {
        LOGGER.debug("BBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("BBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("BBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("BBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "test112221";
    }


    @RequestMapping({"test3"})
    public String getSomething3() {
        LOGGER.debug("ccccccccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "test112221cccccccccccc";
    }


}
