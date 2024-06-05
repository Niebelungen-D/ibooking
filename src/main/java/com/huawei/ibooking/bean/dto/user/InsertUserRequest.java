package com.huawei.ibooking.bean.dto.user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertUserRequest {

    String userName;

    String password;

    String userEmail;

    String userHeadimg;

    Integer userRole;

}
