package com.hz.springboot.business.service.impl;


import com.hz.springboot.base.utils.DateUtil;
import com.hz.springboot.business.mybatis.mapper.MkmRecommendPopupRecordsPoMapper;
import com.hz.springboot.business.mybatis.mapper.PointPositionMapper;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPo;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPoExample;
import com.hz.springboot.business.pojo.PointPosition;
import com.hz.springboot.business.pojo.PointPositionExample;
import com.hz.springboot.business.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Autowired
    private MkmRecommendPopupRecordsPoMapper mkmRecommendPopupRecordsPoMapper;


    @Autowired
    private PointPositionMapper pointPositionMapper;

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


}
