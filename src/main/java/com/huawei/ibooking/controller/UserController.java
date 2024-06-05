package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.dto.user.*;
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
        String username = loginRequest.getUserName();
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
                .setUserRole(user.getUserRole())
                .setUserId(user.getUserId());
        return new JsonResult<>(securityUser);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<Object> register(
            @ApiParam(required = true) @RequestBody RegisterRequest registerRequest
    ) {

        String password = registerRequest.getPassword();
        String username = registerRequest.getUserName();
        String userHeadimg = registerRequest.getUserHeadimg();
        String userEmail = registerRequest.getUserEmail();
        if (ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(userHeadimg) || ObjectUtils.isEmpty(userEmail)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }

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

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public PageInfo<SecurityUser> query(
            @ApiParam(required = false) @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(required = false) @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(required = false) @RequestParam(name = "sort", defaultValue = "user_id DESC") String sort
    ) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        return userService.selectPageByExample(example, pageNum, pageSize, sort);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public JsonResult<Object> insert(
        @ApiParam(required = true) @RequestBody InsertUserRequest insertUserRequest
    ) {
        String userHeadimg = insertUserRequest.getUserHeadimg();
        String userEmail = insertUserRequest.getUserEmail();
        String userName = insertUserRequest.getUserName();
        String password = insertUserRequest.getPassword();
        Integer userRole = insertUserRequest.getUserRole();

        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(password);
        user.setUserHeadimg(userHeadimg);
        user.setUserRole(userRole);
        user.setUserEmail(userEmail);
        int insert = userService.insert(user);
        if (insert >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult<Object> update(
        @ApiParam(required = true) @RequestBody UpdateUserRequest updateUserRequest
    ) {
        String userHeadimg = updateUserRequest.getUserHeadimg();
        String userEmail = updateUserRequest.getUserEmail();
        String userName = updateUserRequest.getUserName();
        String password = updateUserRequest.getPassword();
        Integer userRole = updateUserRequest.getUserRole();

        Long userId = updateUserRequest.getUserId();

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPwd(password);
        user.setUserHeadimg(userHeadimg);
        user.setUserRole(userRole);
        user.setUserEmail(userEmail);

        int update = userService.updateByPrimaryKeySelective(user);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonResult<Object> delete(
            @ApiParam(required = true) @RequestBody DeleteUserRequest deleteUserRequest
    ) {
        Long userId = deleteUserRequest.getUserId();
        int i = userService.deleteByPrimaryKey(userId);
        if (i >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
