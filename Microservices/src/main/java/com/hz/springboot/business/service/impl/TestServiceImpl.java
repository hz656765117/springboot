package com.hz.springboot.business.service.impl;


import com.hz.springboot.base.utils.DateUtil;
import com.hz.springboot.business.mybatis.mapper.MkmRecommendPopupRecordsPoMapper;
import com.hz.springboot.business.mybatis.mapper.PointPositionMapper;
import com.hz.springboot.business.mybatis.mapper.WechatInfoMapper;
import com.hz.springboot.business.pojo.*;
import com.hz.springboot.business.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Autowired
    private MkmRecommendPopupRecordsPoMapper mkmRecommendPopupRecordsPoMapper;


    @Autowired
    private PointPositionMapper pointPositionMapper;

    @Autowired
    private WechatInfoMapper wechatInfoMapper;


    @Override
    public boolean checkNeedPopup(String channel) {
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = queryPopupList(channel);
        return mkmRecommendPopupRecordsPos != null && mkmRecommendPopupRecordsPos.size() > 0 ? true : false;
    }

    @Override
    public PointPosition getSomething(String direction, String len) {
        PointPosition pointPosition = getLessThanOrEqualLen(direction, len);
        PointPosition greaterThanOrEqualLen = getGreaterThanOrEqualLen(direction, len);
        if (greaterThanOrEqualLen == null) {
            pointPosition = new PointPosition();
            pointPosition.setRemark("outRange");
        }

        return pointPosition;
    }

    public PointPosition getLessThanOrEqualLen(String direction, String len) {
        PointPositionExample example = new PointPositionExample();
        example.createCriteria().andDirectionEqualTo(direction).andLenLessThanOrEqualTo(Integer.valueOf(len));
        example.setOrderByClause("len desc");
        List<PointPosition> pointPositions = pointPositionMapper.selectByExample(example);
        return pointPositions != null && pointPositions.size() > 0 ? pointPositions.get(0) : new PointPosition();
    }

    public PointPosition getGreaterThanOrEqualLen(String direction, String len) {
        PointPositionExample example = new PointPositionExample();
        example.createCriteria().andDirectionEqualTo(direction).andLenGreaterThanOrEqualTo(Integer.valueOf(len));
        example.setOrderByClause("len asc");
        List<PointPosition> pointPositions = pointPositionMapper.selectByExample(example);
        return pointPositions != null && pointPositions.size() > 0 ? pointPositions.get(0) : null;
    }

    public List<MkmRecommendPopupRecordsPo> queryPopupList(String channel) {
        MkmRecommendPopupRecordsPoExample example = new MkmRecommendPopupRecordsPoExample();
        String curTime = DateUtil.convertDateToString(new Date(), DateUtil.dataFormatHHmmss);
        example.createCriteria().andEffectBeginTimeLessThanOrEqualTo(curTime).andEffectEndTimeGreaterThanOrEqualTo(curTime).andChannelEqualTo(channel);
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = mkmRecommendPopupRecordsPoMapper.selectByExample(example);
        logger.info("数据条数为：{}", mkmRecommendPopupRecordsPos != null ? mkmRecommendPopupRecordsPos.size() : 0);
        return mkmRecommendPopupRecordsPos;
    }


    @Override
    public Map<String, Map<String,List<Schedule>>> getSchedule(String userId) {
        Schedule schedule0 = new Schedule("语文","1","1");
        Schedule schedule1 = new Schedule("数学","1","2");
        Schedule schedule2 = new Schedule("英语","1","3");
        Schedule schedule3 = new Schedule("化学","1","4");
        Schedule schedule4 = new Schedule("生物","1","5");

        Schedule schedule10 = new Schedule("数学","2","1");
        Schedule schedule11 = new Schedule("英语","2","2");
        Schedule schedule12 = new Schedule("生物","2","3");
        Schedule schedule13 = new Schedule("化学","2","4");
        Schedule schedule14 = new Schedule("语文","2","5");

        List<Schedule> list = new ArrayList<>();
        list.add(schedule0);
        list.add(schedule1);
        list.add(schedule2);
        list.add(schedule3);
        list.add(schedule4);
        list.add(schedule10);
        list.add(schedule11);
        list.add(schedule12);
        list.add(schedule13);
        list.add(schedule14);

        Map<String, Map<String,List<Schedule>>> allMap =new TreeMap<>();


        for (int i =0 ;i<list.size();i++) {
            Schedule schedule = list.get(i);
            String name = schedule.getTimePeriod();
            String curName = schedule.getTimePeriod() + "_"+ schedule.getDayOfWeek();
            if (allMap.get(name)!=null){
                Map<String,List<Schedule>> curMap = allMap.get(name);

                List<Schedule> schedules = curMap.get(curName);
                if (schedules== null){
                    schedules = new ArrayList<>();
                }

                schedules.add(schedule);

                curMap.put(curName,schedules);
            }else{
                List<Schedule> curList = new ArrayList<>();
                curList.add(schedule);
                Map<String,List<Schedule>> map =new HashMap<>();
                map.put(curName,curList);
                allMap.put(name,map);
            }
        }

        return allMap;
    }


    @Override
    public WechatInfo getWethatInfo(String id) {
        WechatInfo wechatInfo = wechatInfoMapper.selectByPrimaryKey(Integer.valueOf(id));
        return wechatInfo;
    }
}
