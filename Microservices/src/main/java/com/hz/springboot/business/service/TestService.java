package com.hz.springboot.business.service;


import com.alibaba.druid.wall.WallSQLException;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPo;
import com.hz.springboot.business.pojo.PointPosition;
import com.hz.springboot.business.pojo.Schedule;
import com.hz.springboot.business.pojo.WechatInfo;

import java.util.List;
import java.util.Map;

public interface TestService {


    /**
     * @author huangzhuo
     * @date 2018/11/5 15:28
     * @description: 检查该渠道在当前时间是否允许弹框
     * @param channel 渠道
     */
    boolean checkNeedPopup(String channel);



    PointPosition getSomething(String direction, String len);



    Map<String, Map<String,List<Schedule>>> getSchedule(String userId);

    WechatInfo getWethatInfo(String id);

}
