package com.hz.springboot.business.controller;

import com.hz.springboot.base.utils.HttpUtil;
import com.hz.springboot.base.utils.IpUtil;
import com.hz.springboot.business.pojo.WechatInfo;
import com.hz.springboot.business.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WechatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatController.class);

    @Autowired
    private TestService testService;

    @CrossOrigin
    @RequestMapping(value = "/wechat/api/openid/{jsCode}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getSchedule(HttpServletRequest request, HttpServletResponse response, @PathVariable String jsCode) {
        LOGGER.info("/wechat/api/openid接口请求，请求参数为{}", jsCode);
        String appid = "";
        String secret = "";
        WechatInfo wethatInfo = testService.getWethatInfo("1");
        if (wethatInfo == null) {
            return "未配置微信相关参数，请联系管理员";
        }
        appid = wethatInfo.getAppid();
        secret = wethatInfo.getSecret();
        String reqUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";
        LOGGER.info("请求为{}", reqUrl);
        String resultStr = HttpUtil.get(reqUrl, null);

        LOGGER.info("方法一的ip{}", IpUtil.getLocalIp(request));
        LOGGER.info("方法二的ip{}", IpUtil.getIp(request));
        LOGGER.info("方法三的ip{}", IpUtil.getIp2(request));

        return resultStr;
    }
}
