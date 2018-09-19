package com.hz.springboot.com.hz.controller;

import com.hz.springboot.com.hz.base.quartz.ScheduleTask;
import com.hz.springboot.com.hz.base.utils.HttpUtil;
import com.hz.springboot.com.hz.base.utils.UrlUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

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


    @RequestMapping({"test4"})
    public String getSomething4() {
        LOGGER.debug("4444444444444ccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("444444444444cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("4444444444444444ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("444444444444444ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "dddddddtest112221cccccccccccc";
    }



    @RequestMapping({"testt"})
    public String getSomething5() {
        LOGGER.debug("4444444444444ccccccBBBBBBBBBBBBBBaaaaaaaaaaadebugdebugdebugtest1111123434");
        LOGGER.info("444444444444cccccccccccBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaainfoinfoinfotest1111123434");
        LOGGER.error("4444444444444444ccccccccccccBBBBBBBBBBBaaaaaaaaaaaaaaaaerrorerrorerrortest1111123434");
        LOGGER.warn("444444444444444ccccccccccBBBBBBBBBBBBaaaaaaaaaaaaaawarnwarnwarntest1warnwarn111123434");
        return "dddddddasssssssssssssssssssssssssssstest112221cccccccccccc";
    }

//    @RequestMapping("/open/api/weather/{city}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8")
//
//    public String getSomethingSS(HttpServletRequest request, @PathVariable String city) {
//        LOGGER.info(city);
//
//
//
//        return "dddddddasssssssssssssssssssssssssssstest112221cccccccccccc";
//    }



    @RequestMapping(value = "/open/api/weather/{city}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateAllSwitch(HttpServletRequest request, HttpServletResponse response, @PathVariable String city) {
        LOGGER.info(city);
        String parm = UrlUtil.getURLEncoderString(city);
        LOGGER.info(parm);
        String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",parm);
        String result = HttpUtil.get(apiUrl,null);
        LOGGER.info(result);
        return result;
    }


//
//
//    public static void main(String[] args) throws Exception{
//        String city = UrlUtil.getURLEncoderString("北京");
//
//
//        System.out.println(city);
//
//        String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
//
////        apiUrl = "http://www.sojson.com/open/api/weather/json.shtml?city=长沙";
//        System.out.println(apiUrl);
//        String result = HttpUtil.get(apiUrl,null);
////        String sCurrentLine = "";
////        String sTotalString = "";
////        try {
////            URL l_url = new URL(apiUrl);
////            HttpURLConnection l_connection = (HttpURLConnection) l_url.openConnection();
////            l_connection.connect();
////            InputStream l_urlStream;
////            l_urlStream = l_connection.getInputStream();
////            BufferedReader l_reader = new BufferedReader(new InputStreamReader(
////                    l_urlStream, "utf-8"));
////            // sCurrentLine = l_reader.readLine();
////            while ((sCurrentLine = l_reader.readLine()) != null) {
////                sTotalString += sCurrentLine + "\r\n";
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        System.out.println(result);
//
//
//    }


}
