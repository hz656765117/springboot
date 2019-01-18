package com.hz.springboot.business.mybatis.mapper;

import com.hz.springboot.business.pojo.WechatSchedule;
import com.hz.springboot.business.pojo.WechatScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WechatScheduleMapper {
    long countByExample(WechatScheduleExample example);

    int deleteByExample(WechatScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatSchedule record);

    int insertSelective(WechatSchedule record);

    List<WechatSchedule> selectByExample(WechatScheduleExample example);

    WechatSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatSchedule record, @Param("example") WechatScheduleExample example);

    int updateByExample(@Param("record") WechatSchedule record, @Param("example") WechatScheduleExample example);

    int updateByPrimaryKeySelective(WechatSchedule record);

    int updateByPrimaryKey(WechatSchedule record);
}