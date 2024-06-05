package com.huawei.ibooking.bean.dto.user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {
    private String userName;
    private String password;
}
