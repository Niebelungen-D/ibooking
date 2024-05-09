package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.po.User;
import com.huawei.ibooking.bean.po.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}