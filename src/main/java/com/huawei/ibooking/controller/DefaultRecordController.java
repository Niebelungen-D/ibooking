package com.huawei.ibooking.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/violation")
@Api(value = "违规管理", tags = {"管理员端违规管理"})
public class DefaultRecordController {


}
