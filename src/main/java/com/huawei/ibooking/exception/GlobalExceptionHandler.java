package com.huawei.ibooking.exception;

import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.commons.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理器
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 客户端错误，请求参数不正确
    public JsonResult<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        // 构建错误信息
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + ", " + msg2)
                .orElse("Validation failed");

        return new JsonResult<>(ResponseEnum.OPERATE_FAILURE.getCode(), message, null);
    }

}
