package com.tour.group.twow.pojo;

import com.tour.group.twow.pojo.States;

public enum StatusCode {
    SUCCESSED(States.SERVER_SUCCESS_STATUS_CODE, "操作成功"),
    UNAUTHORIZED(States.UNAUTHORIZED, "权限不足"),
    FAILED(States.SERVER_FAILED_STATUS_CODE,"请求失败"),
    FAILEDNONDATA(States.SERVER_NONDATARETURN_STATUS_CODE,"无数据返回！");
    private Integer code;
    private String message;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
