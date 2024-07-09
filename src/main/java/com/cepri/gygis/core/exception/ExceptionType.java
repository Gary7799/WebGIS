package com.cepri.gygis.core.exception;

public enum ExceptionType {
    INNER_ERROR(500, "内部错误"),
    UNAUTHORIZED(401, "未登录"),
    NOT_FOUND(404, "资源未找到"),
    FORBIDDEN(403, "无权操作"),
    BAD_REQUEST(400, "错误的请求"),
    USER_NAME_DUPLICATE(10001, "用户名已存在"),
    USER_NOT_FOUND(10002, "用户不存在"),
    USER_PASSWORD_NOT_MATCH(10003, "用户名或密码错误"),
    USER_NOT_ENABLED(10004, "用户未激活"),
    USER_LOCKED(10005, "用户被锁定"),
    MUSIC_NOT_FOUND(111, "歌曲不存在");


    private final Integer code;

    private final String message;

    ExceptionType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
