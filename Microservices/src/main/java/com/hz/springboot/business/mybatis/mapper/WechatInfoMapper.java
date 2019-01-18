package com.hz.springboot.business.mybatis.mapper;

import com.hz.springboot.business.pojo.WechatInfo;
import com.hz.springboot.business.pojo.WechatInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WechatInfoMapper {
    long countByExample(WechatInfoExample example);

    int deleteByExample(WechatInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatInfo record);

    int insertSelective(WechatInfo record);

    List<WechatInfo> selectByExample(WechatInfoExample example);

    WechatInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    int updateByExample(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    int updateByPrimaryKeySelective(WechatInfo record);

    int updateByPrimaryKey(WechatInfo record);
}