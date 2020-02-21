package com.demo.model;

import java.io.Serializable;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
public class ResponseResult<T> implements Serializable {

    public static final Integer SUCCESS_CODE = 1;
    public static final Integer ERROR_CODE = 0;

    private Integer code;
    private String msg;
    private T data;

    private ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static ResponseResult buildErrorResponse(int errCode, String errMsg) {
        return new ResponseResult(errCode, errMsg, null);
    }

    public static <S> ResponseResult<S> buildErrorResponse(int errCode, String errMsg, S result) {
        return new ResponseResult(errCode, errMsg, result);
    }

    public static <S> ResponseResult<S> buildSuccessResponse(S result) {
        return new ResponseResult(SUCCESS_CODE, "请求成功", result);
    }
}
