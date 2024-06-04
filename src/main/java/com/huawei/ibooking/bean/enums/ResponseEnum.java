package com.huawei.ibooking.bean.enums;


public enum ResponseEnum {

    //Config Error 1xxx  基础配置异常
    SYSTEM_ERROR("1000", "系统错误"),
    DATABASE_ERROR("1001", "数据库异常"),
    CONNECTION_ERROR("1002", "网络连接请求失败"),

    //Success 2xxx  业务逻辑成功
    OPERATE_SUCCESS("2000", "操作成功"), //赖皮
    REGISTER_SUCCESS("2001", "注册成功"),
    LOGIN_SUCCESS("2002", "登陆成功"),
    LOGOUT_SUCCESS("2003", "已退出登录"),
    SEND_EMAIL_SUCCESS("2004", "邮件已发送，请注意查收"),
    EDIT_PWD_SUCCESS("2005", "修改密码成功"),
    UPLOAD_FILE_SUCCESS("2006", "上传成功"),
    QUERY_SUCCESS("2007", "查询成功"),
    RAW_DATA_CORRECT("2008", "数据正确"),
    USER_NOT_BROWSING_ANY_USER("2009", "用户尚未看过任何人"),
    WS_CONNECTED_SUCCESS("2010", "websocket连接成功"),
    WS_DISCONNECTED_SUCCESS("2011", "websocket连接关闭成功"),
    FANS_ALREADY_ADDED("2012", "已关注"),
    FANS_BLACK_LIST_ADDED("2013", "拉黑后重新关注"),
    FANS_NEW("2014", "新增粉丝"),
    RECOMMEND_NO_USER_CAN_RECOMMEND("2015", "没有相关的user可以推荐"),
    ONLY_SAY_HI("2016", "值打过招呼"),

    //Error 3xxx  业务逻辑失败
    OPERATE_FAILURE("3000", "操作失败"),
    REPEAT_REGISTER("3001", "重复注册"),
    NO_USER_EXIST("3002", "用户不存在"),
    INVALID_PASSWORD("3003", "密码错误"),
    NO_LOGIN("3004", "未登陆"),
    NO_FILE_SELECT("3005", "未选择文件"),
    CODE_INCORRECT("3006", "验证码不正确"),
    NO_RECORD("3007", "没有查到相关记录"),
    REPEAT_MOBILE("3008", "已存在此手机号"),
    REPEAT_EMAIL("3009", "已存在此邮箱地址"),
    INVALID_MOBILE("3010", "无效的手机号码"),
    INVALID_EMAIL("3011", "无效的邮箱"),
    INVALID_GENDER("3012", "无效的性别"),
    WECHAT_SYSTEM_BUSY("3013", "微信系统繁忙"),
    EMPTY_JSCODE("3014", "jsCode为空"),
    CODE2SESSION_ERROR("3015", "code2session接口请求出错"),
    JSCODE_EXPIRED("3016", "jsCode过期"),
    JSCODE_USELESS("3017", "jsCode无效"),
    API_CALL_FREQUENTLY("3018", "API调用频繁，请稍后再试"),
    USER_DANGER_ACCESS_DENIED("3019", "高风险等级用户，小程序登录拦截，禁止访问"),
    EMPTY_MOBILE("3020", "手机号为空"),
    EMPTY_UUID("3021", "UUID为空"),
    EMPTY_AGE_DURATION("3022", "缺少年龄范围"),
    EMPTY_SCHOOLS("3023", "缺少具体学校范围"),
    EMPTY_BAN_USER("3024", "缺少被ban列表"),
    LEAST_ONE_NOT_EMPTY("3025", "至少应有一个字段不为空"),
    USER_DELETED("3026", "用户已注销，禁止操作"),
    USER_ALREADY_DELETED("3027", "用户已经注销，无需操作"),
    ACCESS_DENIED("3028", "越权操作"),
    RAW_DATA_ILLEGAL("3029", "数据非法"),
    WS_EMPTY_FROM_UUID("3030", "缺少fromUuid"),
    WS_EMPTY_TO_UUID("3031", "缺少toUuid"),
    WS_NO_FROM_USER("3032", "没有fromUuid此用户"),
    WS_NO_TO_USER("3033", "没有toUuid此用户"),
    WS_FROM_DELETED("3034", "fromUuid已注销"),
    WS_TO_DELETED("3035", "toUuid已注销"),
    WS_EMPTY_PARAM("3026", "参数不能为空"),
    WS_EMPTY_DATA("3027", "没有此数据"),
    USER_NOT_AUTH_SCHOOL("3028", "用户尚未认证学校"),
    USER_ALREADY_REGISTERED("3029", "用户名已经注册过了"),
    USERNAME_PASSWORD_WRONG("3030", "账号密码错误"),
    EXCEED_GREETING_TIMES("3031", "打招呼次数超限"),
    EXCEED_WEEKLY_GREETING_TIMES("3032", "本周打招呼次数已用完"),
    DUPLICATE_CONTENT("3033", "提交重复内容"),
    TOKEN_ERROR("3034", "access_token获取失败"),

    STUDY_ROOM_EXIST("3035", "自习室已存在"),
    SEAT_EXIST("3036", "座位已存在"),

    SEAT_RESERVATION_CONFLICT("3037", "时间段内座位已被预约"),

    RESERVATION_CHECKED("3038", "该预约已经签到过"),

    SEAT_NOT_EXIST("3039", "座位不存在"),


    //Client Error 4xxx  客户端错误  仿照4xx的http错误
    BAD_REQUEST("4000", "错误的请求参数"),
    UNAUTHORIZED("4001", "未经授权"),
    PAYMENT_REQUIRED("4002", "付费请求"),
    FORBIDDEN("4003", "资源不可用"),
    NOT_FOUND("4004", "无效的访问路径"),
    METHOD_NOT_ALLOWED("4005", "不合法的请求方式"),
    NOT_ACCEPTABLE("4006", "不可接受"),
    PROXY_AUTHENTICATION_REQUIRED("4007", "需要代理身份验证"),
    REQUEST_TIMEOUT("4008", "请求超时"),
    CONFLICT("4009", "指令冲突"),
    GONE("4010", "文档永久地离开了指定的位置"),
    LENGTH_REQUIRED("4011", "需要CONTENT-LENGTH头请求"),
    PRECONDITION_FAILED("4012", "前提条件失败"),
    REQUEST_ENTITY_TOO_LARGE("4013", "请求实体太大"),
    REQUEST_URI_TOO_LONG("4014", "请求URI太长"),
    UNSUPPORTED_MEDIA_TYPE("4015", "不支持的媒体类型"),
    REQUESTED_RANGE_NOT_SATISFIABLE("4016", "请求的范围不可满足"),
    EXPECTATION_FAILED("4017", "期望失败"),

    WS_NOT_ESTABLISHED("4018", "websocket尚未建立"),
    NOT_FANS("4019", "未关注"),
    WS_EMPTY_MESSAGE_TYPE("4020", "缺少type参数"),
    NO_USER("4021", "没有此用户"),

    PARAM_NOT_ALLOWED("4022", "不合法的参数取值"),

    //Server Error 5xxx  服务器错误  仿照5xx的http错误
    INTERNAL_SERVER_ERROR("5000", "内部服务器错误"),
    NOT_IMPLEMENTED("5001", "未实现"),
    BAD_GATEWAY("5002", "错误的网关"),
    SERVICE_UNAVAILABLE("5003", "服务不可用"),
    GATEWAY_TIMEOUT("5004", "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED("5005", "HTTP版本不支持"),

    //终极赖皮手段
    UNKNOWN_ERROR("0000", "未知错误");

    private String code;
    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}