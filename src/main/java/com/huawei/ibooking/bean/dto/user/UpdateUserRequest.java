package com.huawei.ibooking.bean.dto.user;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {

    Long userId;

    String userName;

    String userEmail;

    String userHeadimg;

    Integer userRole;

    String password;

}
