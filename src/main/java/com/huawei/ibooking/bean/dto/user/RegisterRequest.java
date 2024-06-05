package com.huawei.ibooking.bean.dto.user;


import io.swagger.annotations.ApiParam;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    String username;

    String password;

    String userEmail;

    String userHeadimg;

}
