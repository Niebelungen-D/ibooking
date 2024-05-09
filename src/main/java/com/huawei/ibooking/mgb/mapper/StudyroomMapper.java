package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.bean.po.StudyroomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyroomMapper {
    long countByExample(StudyroomExample example);

    int deleteByExample(StudyroomExample example);

    int deleteByPrimaryKey(Integer studyroomId);

    int insert(Studyroom row);

    int insertSelective(Studyroom row);

    List<Studyroom> selectByExample(StudyroomExample example);

    Studyroom selectByPrimaryKey(Integer studyroomId);

    int updateByExampleSelective(@Param("row") Studyroom row, @Param("example") StudyroomExample example);

    int updateByExample(@Param("row") Studyroom row, @Param("example") StudyroomExample example);

    int updateByPrimaryKeySelective(Studyroom row);

    int updateByPrimaryKey(Studyroom row);
}