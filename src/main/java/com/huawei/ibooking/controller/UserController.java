package com.huawei.ibooking.controller;

import com.huawei.ibooking.bean.dto.user.LoginRequest;
import com.huawei.ibooking.bean.enums.RoleEnum;
import com.huawei.ibooking.bean.po.User;
import com.huawei.ibooking.bean.po.UserExample;
import com.huawei.ibooking.bean.vo.user.SecurityUser;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.serivce.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "用户权限控制", tags = {"用户权限控制"})
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<SecurityUser> login(
            @ApiParam(required = true) @RequestBody LoginRequest loginRequest
    ) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> users = userService.selectByExample(example);
        if (ObjectUtils.isEmpty(users)) {
            return new JsonResult<>(ResponseEnum.NO_USER);
        }
        User user = users.get(0);
        if (!password.equals(user.getUserPwd())) {
            return new JsonResult<>(ResponseEnum.INVALID_PASSWORD);
        }
        SecurityUser securityUser = new SecurityUser();

        securityUser.setUserName(user.getUserName())
                .setUserHeadimg(user.getUserHeadimg())
                .setUserEmail(user.getUserEmail())
                .setUserRole(user.getUserRole());
        return new JsonResult<>(securityUser);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<Object> register(
            @ApiParam(required = true) @RequestParam(name = "username") String username,
            @ApiParam(required = true) @RequestParam(name = "password") String password,
            @ApiParam(required = true) @RequestParam(name = "useremail") String userEmail,
            @ApiParam(required = true) @RequestParam(name = "userHeadimg") String userHeadimg
    ) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> adminUsers = userService.selectByExample(example);
        if (!adminUsers.isEmpty()) {
            return new JsonResult<>(ResponseEnum.USER_ALREADY_REGISTERED);
        }

        User user = new User();
        user.setUserName(username);
        user.setUserEmail(userEmail);
        user.setUserHeadimg(userHeadimg);
        user.setUserPwd(password);
        user.setUserRole(RoleEnum.NORMAL_USER.getCode());
        userService.insert(user);
        return new JsonResult<>(ResponseEnum.REGISTER_SUCCESS);
    }

}
