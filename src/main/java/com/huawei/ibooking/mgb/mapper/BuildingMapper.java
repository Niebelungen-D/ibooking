package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.Building;
import com.huawei.ibooking.bean.po.BuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {
    long countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(Integer buildingId);

    int insert(Building row);

    int insertSelective(Building row);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(Integer buildingId);

    int updateByExampleSelective(@Param("row") Building row, @Param("example") BuildingExample example);

    int updateByExample(@Param("row") Building row, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building row);

    int updateByPrimaryKey(Building row);
}