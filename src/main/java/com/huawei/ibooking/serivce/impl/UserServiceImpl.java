package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.User;
import com.huawei.ibooking.bean.po.UserExample;
import com.huawei.ibooking.bean.vo.user.SecurityUser;
import com.huawei.ibooking.mgb.mapper.UserMapper;
import com.huawei.ibooking.serivce.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo<SecurityUser> selectPageByExample(UserExample example, Integer pageNum, Integer pageSize, String sort) {
        PageHelper.startPage(pageNum, pageSize);
//        example.setOrderByClause(sort);
        List<User> users = userMapper.selectByExample(example);
        List<SecurityUser> securityUserList = new ArrayList<>();
        users.forEach(user -> {
            SecurityUser securityUser = new SecurityUser();
            securityUser.setUserRole(user.getUserRole());
            securityUser.setUserId(user.getUserId());
            securityUser.setUserEmail(user.getUserEmail());
            securityUser.setUserHeadimg(user.getUserHeadimg());
            securityUser.setUserName(user.getUserName());
            securityUserList.add(securityUser);
        });
        return new PageInfo<>(securityUserList);
    }



    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return userMapper.updateByExample(record, example);
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User row) {
        return userMapper.updateByPrimaryKey(row);
    }
}
