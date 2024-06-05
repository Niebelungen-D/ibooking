package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.TblBookingXxx;
import com.huawei.ibooking.bean.po.TblBookingXxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblBookingXxxMapper {
    long countByExample(TblBookingXxxExample example);

    int deleteByExample(TblBookingXxxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblBookingXxx row);

    int insertSelective(TblBookingXxx row);

    List<TblBookingXxx> selectByExample(TblBookingXxxExample example);

    TblBookingXxx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TblBookingXxx row, @Param("example") TblBookingXxxExample example);

    int updateByExample(@Param("row") TblBookingXxx row, @Param("example") TblBookingXxxExample example);

    int updateByPrimaryKeySelective(TblBookingXxx row);

    int updateByPrimaryKey(TblBookingXxx row);
}