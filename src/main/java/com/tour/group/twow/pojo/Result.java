package com.tour.group.twow.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T> {
    private int retCode;
    private Map data;
    private String message;
    private Result(){

    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public Result(StatusCode code){
        this.retCode=code.getCode();
        this.message=code.getMessage();
    }
    public Result(StatusCode code, T item) {
        Map map = new HashMap();
        map.put("retValue", item);
        this.data = map;
        this.message = code.getMessage();
        this.retCode = code.getCode();
    }
    public Result(StatusCode code, Map data){
        this.retCode=code.getCode();
        this.message=code.getMessage();
        this.data=data;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }



    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    //成功并且返回数据
    public static Result success(Object data){
        return new Result(StatusCode.SUCCESSED, data);
    }
    //成功并无数据
    public static Result success(){
        return new Result(StatusCode.SUCCESSED, "操作成功");
    }
    //成功并无数据
    public static Result success(String message){
        return new Result(StatusCode.SUCCESSED, message);
    }
    public static Result unauthorized() {
        return new Result(StatusCode.UNAUTHORIZED);
    }
    public static Result failed() {
        return new Result(StatusCode.FAILED);
    }
}
