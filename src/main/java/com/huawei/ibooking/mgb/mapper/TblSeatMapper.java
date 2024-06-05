package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.TblSeat;
import com.huawei.ibooking.bean.po.TblSeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSeatMapper {
    long countByExample(TblSeatExample example);

    int deleteByExample(TblSeatExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("studyroomid") Integer studyroomid);

    int insert(TblSeat row);

    int insertSelective(TblSeat row);

    List<TblSeat> selectByExample(TblSeatExample example);

    int updateByExampleSelective(@Param("row") TblSeat row, @Param("example") TblSeatExample example);

    int updateByExample(@Param("row") TblSeat row, @Param("example") TblSeatExample example);
}