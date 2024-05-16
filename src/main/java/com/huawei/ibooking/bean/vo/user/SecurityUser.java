package com.huawei.ibooking.bean.vo.user;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SecurityUser {

    /*
    * 用户名
    *
    * */
    private String userName;

    /*
    *
    * 用户邮箱
    * */
    private String userEmail;


    /*
    * 用户头像
    *
    * */
    private String userHeadimg;

    /*
    * 用户角色
    *
    * */
    private Integer userRole;

}
