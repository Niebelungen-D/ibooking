package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.TblStudyRoom;
import com.huawei.ibooking.bean.po.TblStudyRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblStudyRoomMapper {
    long countByExample(TblStudyRoomExample example);

    int deleteByExample(TblStudyRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblStudyRoom row);

    int insertSelective(TblStudyRoom row);

    List<TblStudyRoom> selectByExample(TblStudyRoomExample example);

    TblStudyRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TblStudyRoom row, @Param("example") TblStudyRoomExample example);

    int updateByExample(@Param("row") TblStudyRoom row, @Param("example") TblStudyRoomExample example);

    int updateByPrimaryKeySelective(TblStudyRoom row);

    int updateByPrimaryKey(TblStudyRoom row);
}