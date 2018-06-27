package com.tour.group.twow.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T> {
    private int retcode;
    private Map data;
    private String message;
    private Result(){

    }
    public Result(StatusCode code){
        this.retcode=code.getCode();
        this.message=code.getMessage();
    }
    public Result(StatusCode code, T item) {
        Map map = new HashMap();
        map.put("retValue", item);
        this.data = map;
        this.message = code.getMessage();
        this.retcode = code.getCode();
    }
    public Result(StatusCode code, Map data){
        this.retcode=code.getCode();
        this.message=code.getMessage();
        this.data=data;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    //成功并且返回数据
    public static Result successWithData(Object data){
        return new Result(StatusCode.SUCCESSED, data);
    }
    public static Result unauthorized() {
        return new Result(StatusCode.UNAUTHORIZED);
    }
    public static Result failed() {
        return new Result(StatusCode.FAILED);
    }
}
