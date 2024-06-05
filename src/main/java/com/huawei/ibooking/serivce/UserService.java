package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.User;
import com.huawei.ibooking.bean.po.UserExample;
import com.huawei.ibooking.bean.vo.user.SecurityUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> selectByExample(UserExample example);

    PageInfo<SecurityUser> selectPageByExample(UserExample example, Integer pageNum, Integer pageSize, String sort);

    int insert(User record);

    int deleteByExample(UserExample example);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int deleteByPrimaryKey(Long userId);


    int updateByPrimaryKeySelective(User row);

}
