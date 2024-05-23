package com.huawei.ibooking.serivce;

import com.huawei.ibooking.bean.po.User;
import com.huawei.ibooking.bean.po.UserExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> selectByExample(UserExample example);

    int insert(User record);

}
