package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.serivce.ReservationService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc; // 用于模拟HTTP请求

    @MockBean
    private ReservationService reservationService; // 手动注入Mock对象

    // 由于ReservationController可能还包含其他自动装配的字段，我们需要使用@MockBean或@Mock来手动创建这些对象
    // @MockBean private OtherService otherService;
    // @Mock private OtherDependency otherDependency;

    @InjectMocks
    private ReservationController reservationController; // 需要测试的控制器

    @Test
    public void testSelectAllReservationsByCondition() throws Exception {
        // 准备测试数据
        PageInfo<ReservationInformation> mockPageInfo = new PageInfo<>(Collections.emptyList());

        // 配置模拟服务层的返回值
        given(reservationService.selectAllReservationsByCondition(
                anyString(), anyString(), anyString(), anyString(), anyInt(), anyInt(), anyString()))
                .willReturn(mockPageInfo);

        // 执行HTTP GET请求
        mockMvc.perform(MockMvcRequestBuilders.get("/reservations/query")
                        .param("userName", "testUser")
                        .param("buildingName", "testBuilding")
                        .param("startTime", "2024-05-31T00:00:00")
                        .param("endTime", "2024-05-31T23:59:59")
                        .param("pageNum", "1")
                        .param("pageSize", "10")
                        .param("orderByClause", "username asc"))
                // 验证响应状态码
                .andExpect(status().isOk())
                // 验证响应内容类型
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
