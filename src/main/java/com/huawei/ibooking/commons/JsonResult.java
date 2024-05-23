package com.huawei.ibooking.commons;

import com.huawei.ibooking.bean.enums.ResponseEnum;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private String code;
    private String msg;

    /**
     * 默认未实现
     */
    public JsonResult() {
        this.code = ResponseEnum.NOT_IMPLEMENTED.getCode();
        this.msg = ResponseEnum.NOT_IMPLEMENTED.getMsg();
    }

    /**
     * 用已有定义的Response返回
     *
     * @param responseEnum
     */
    public JsonResult(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    /**
     * 主要展示后端异常
     *
     * @param responseEnum
     * @param additionalMsg
     */
    public JsonResult(ResponseEnum responseEnum, String additionalMsg) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg() + "\nexpectation:" + additionalMsg;
    }

    /**
     * 自定义状态返回
     *
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作成功，需要返回数据
     *
     * @param data
     */
    public JsonResult(T data) {
        this.code = ResponseEnum.OPERATE_SUCCESS.getCode();
        this.msg = ResponseEnum.OPERATE_SUCCESS.getMsg();
        this.data = data;
    }

    public static <T> JsonResult<T> success(){
        return JsonResult.success(null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS.getCode(), ResponseEnum.OPERATE_SUCCESS.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> JsonResult<T> success(T data, String message) {
        return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> JsonResult<T> failed(ResponseEnum errorCode) {
        return new JsonResult<>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> JsonResult<T> failed(ResponseEnum errorCode, String message) {
        return new JsonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> JsonResult<T> failed(String message) {
        return new JsonResult<>(ResponseEnum.OPERATE_FAILURE.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> JsonResult<T> failed() {
        return failed(ResponseEnum.OPERATE_FAILURE);
    }
    /**
     * 参数验证失败返回结果
     */
    public static <T> JsonResult<T> validateFailed() {
        return failed(ResponseEnum.BAD_REQUEST);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> JsonResult<T> validateFailed(String message) {
        return new JsonResult<>(ResponseEnum.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> JsonResult<T> unauthorized(T data) {
        return new JsonResult<>(ResponseEnum.UNAUTHORIZED.getCode(), ResponseEnum.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> JsonResult<T> forbidden(T data) {
        return new JsonResult<>(ResponseEnum.FORBIDDEN.getCode(), ResponseEnum.FORBIDDEN.getMsg(), data);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                " data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
