package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.bean.po.StudyroomExample;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.StudyroomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudyroomControllerTest {

    @Mock
    private StudyroomService studyroomService;

    @InjectMocks
    private StudyRoomController studyRoomController; // 用你的控制器类替换

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studyRoomController).build();
    }

    @Test
    public void testUpdateStudyroom() throws Exception {
//        // 准备测试数据
//        Integer studyroomId = 1;
//        Boolean roomStatus = true;
//
//        // 配置模拟对象的预期行为
//        when(studyroomService.updateByExample(any(Studyroom.class), any(StudyroomExample.class)))
//                .thenReturn(1); // 假设服务层返回1，表示更新成功
//
//        // 执行测试
//        JsonResult<Object> result = studyRoomController.update(studyroomId, roomStatus);
//
//        // 验证是否调用了服务层的方法
//        verify(studyroomService).updateByExample(any(Studyroom.class), any(StudyroomExample.class));
//
//        // 断言结果是否符合预期
//        Assertions.assertEquals(ResponseEnum.OPERATE_SUCCESS.getCode(), result.getCode());
    }


    @Test
    public void testInsertStudyroom() throws Exception {
        // 准备测试数据
        Boolean roomStatus = true; // 该参数在insert方法中未使用，但需提供以满足@RequestParam要求
        Integer studyroomNumer = 101; // 假设的自习室编号
        Integer buildingId = 1; // 假设的楼栋ID

        // 配置模拟对象的预期行为
        when(studyroomService.countByExample(any(StudyroomExample.class))).thenReturn(0L); // 假设没有找到自习室
        when(studyroomService.insert(any(Studyroom.class))).thenReturn(1); // 假设插入成功

        // 构建MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(studyRoomController)
                .defaultRequest(MockMvcRequestBuilders.post("/api/v1/studyroom/insert")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("room_status", String.valueOf(roomStatus))
                        .param("studyroom_number", String.valueOf(studyroomNumer))
                        .param("building_id", String.valueOf(buildingId)))
                .build();

        // 执行测试
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/studyroom/insert")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("room_status", String.valueOf(roomStatus))
                        .param("studyroom_number", String.valueOf(studyroomNumer))
                        .param("building_id", String.valueOf(buildingId)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseEnum.OPERATE_SUCCESS.getCode()));

        // 验证是否调用了服务层的方法
        verify(studyroomService, times(1)).countByExample(any(StudyroomExample.class));
        verify(studyroomService, times(1)).insert(any(Studyroom.class));

        // 这里不需要返回值的断言，因为MockMvc已经验证了响应状态和JSON路径
    }

    @Test
    public void testGetStudyRoomList() {
        // 准备测试数据
        Boolean roomStatus = true; // 示例参数，根据需要设置
        Integer studyroomNumer = 101; // 示例参数，根据需要设置
        Integer buildingId = 1; // 示例参数，根据需要设置
        Integer pageNum = 1; // 示例参数，默认值
        Integer pageSize = 10; // 示例参数，默认值
        String sort = "id DESC"; // 示例参数，默认值

        // 创建模拟的PageInfo对象
        PageInfo<StudyRoomInformation> mockPageInfo = new PageInfo<>(new ArrayList<>()); // 这里可以添加测试数据

        // 配置模拟对象的预期行为
        when(studyroomService.selectByExample(any(), anyInt(), anyInt(), any()))
                .thenReturn(mockPageInfo);

        // 执行测试
        JsonResult<PageInfo<StudyRoomInformation>> result = studyRoomController.getStudyRoomList(
                roomStatus, studyroomNumer, buildingId, pageNum, pageSize, sort);

        // 验证是否调用了服务层的方法
        verify(studyroomService).selectByExample(any(), anyInt(), anyInt(), any());

        // 断言结果是否符合预期
        assertNotNull(result, "The JsonResult object should not be null");
        Assertions.assertEquals(result.getCode(), "2000", ResponseEnum.OPERATE_SUCCESS.getCode());
//        Assertions.assertEquals(new PageInfo[]{result.getData()}, "The data should match the mock PageInfo", String.valueOf(mockPageInfo));
    }

}
