package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.DefaultRecord;
import com.huawei.ibooking.bean.po.DefaultRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefaultRecordMapper {
    long countByExample(DefaultRecordExample example);

    int deleteByExample(DefaultRecordExample example);

    int deleteByPrimaryKey(Integer dId);

    int insert(DefaultRecord row);

    int insertSelective(DefaultRecord row);

    List<DefaultRecord> selectByExample(DefaultRecordExample example);

    DefaultRecord selectByPrimaryKey(Integer dId);

    int updateByExampleSelective(@Param("row") DefaultRecord row, @Param("example") DefaultRecordExample example);

    int updateByExample(@Param("row") DefaultRecord row, @Param("example") DefaultRecordExample example);

    int updateByPrimaryKeySelective(DefaultRecord row);

    int updateByPrimaryKey(DefaultRecord row);
}