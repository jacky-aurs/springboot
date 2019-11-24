package com.example.demo.result;

import java.io.Serializable;

/**
 * 定义返回数据格式
 */
public class ResultModel implements Serializable {

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private int code;
    private String msg;
    private Object data;

    public ResultModel() {

    }

    public ResultModel(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
