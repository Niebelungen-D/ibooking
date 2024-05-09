package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成user表实体类
 * @date 2024-05-09 05:41
 */
public class User implements Serializable {
    /**
     * 会员编号
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 会员账号
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 会员密码
     *
     * @mbg.generated
     */
    private String userPwd;

    /**
     * 会员邮箱
     *
     * @mbg.generated
     */
    private String userEmail;

    /**
     * 会员权限（默认为0）
     * 0：普通会员 1：管理员
     *
     * @mbg.generated
     */
    private Integer userRole;

    /**
     * 会员头像
     *
     * @mbg.generated
     */
    private String userHeadimg;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userRole=").append(userRole);
        sb.append(", userHeadimg=").append(userHeadimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}