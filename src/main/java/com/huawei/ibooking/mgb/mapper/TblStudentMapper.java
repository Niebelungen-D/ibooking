package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.TblStudent;
import com.huawei.ibooking.bean.po.TblStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblStudentMapper {
    long countByExample(TblStudentExample example);

    int deleteByExample(TblStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblStudent row);

    int insertSelective(TblStudent row);

    List<TblStudent> selectByExample(TblStudentExample example);

    TblStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TblStudent row, @Param("example") TblStudentExample example);

    int updateByExample(@Param("row") TblStudent row, @Param("example") TblStudentExample example);

    int updateByPrimaryKeySelective(TblStudent row);

    int updateByPrimaryKey(TblStudent row);
}