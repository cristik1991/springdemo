package com.cristik.framework.base;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cristik on 2016/3/13.
 */
public class BaseController {

    public String success(String msg){
        Result result = new Result(true,msg);
        result.setStatus("y");
        return result.toString();
    }

    public String error(String msg){
        Result result = new Result(false,msg);
        result.setStatus("n");
        return result.toString();
    }

    public String success(String msg,Object obj){
        Result result = new Result(true,msg);
        result.put("result",obj);
        result.setStatus("y");
        return result.toString();
    }

    public String error(String msg,Object obj){
        Result result = new Result(false,msg);
        result.put("result",obj);
        result.setStatus("n");
        return result.toString();
    }


}
