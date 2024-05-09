package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckRecordMapper {
    long countByExample(CheckRecordExample example);

    int deleteByExample(CheckRecordExample example);

    int deleteByPrimaryKey(Integer checkId);

    int insert(CheckRecord row);

    int insertSelective(CheckRecord row);

    List<CheckRecord> selectByExample(CheckRecordExample example);

    CheckRecord selectByPrimaryKey(Integer checkId);

    int updateByExampleSelective(@Param("row") CheckRecord row, @Param("example") CheckRecordExample example);

    int updateByExample(@Param("row") CheckRecord row, @Param("example") CheckRecordExample example);

    int updateByPrimaryKeySelective(CheckRecord row);

    int updateByPrimaryKey(CheckRecord row);
}