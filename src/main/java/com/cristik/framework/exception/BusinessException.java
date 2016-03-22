package com.cristik.framework.exception;

/**
 * Created by zhenghua on 2016/3/18.
 */
public class BusinessException extends Exception{

    String msg = "";

    String code = "";

    public BusinessException(){

    }

    public BusinessException(String msg){
        this.msg=msg;
    }

    public BusinessException(String msg,String code){
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
