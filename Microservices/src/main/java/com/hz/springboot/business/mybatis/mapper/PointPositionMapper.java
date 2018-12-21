package com.hz.springboot.business.mybatis.mapper;

import com.hz.springboot.business.pojo.PointPosition;
import com.hz.springboot.business.pojo.PointPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointPositionMapper {
    long countByExample(PointPositionExample example);

    int deleteByExample(PointPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointPosition record);

    int insertSelective(PointPosition record);

    List<PointPosition> selectByExample(PointPositionExample example);

    PointPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointPosition record, @Param("example") PointPositionExample example);

    int updateByExample(@Param("record") PointPosition record, @Param("example") PointPositionExample example);

    int updateByPrimaryKeySelective(PointPosition record);

    int updateByPrimaryKey(PointPosition record);
}