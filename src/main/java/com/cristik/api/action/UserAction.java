package com.cristik.api.action;

import com.cristik.business.entity.svo.User;
import com.cristik.business.service.UserService;
import com.cristik.framework.exception.BusinessException;
import com.cristik.framework.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhenghua on 2016/3/18.
 */
@Controller
@RequestMapping("/api/user")
public class UserAction  extends BaseAction{
    @Autowired
    UserService userservice;

    @RequestMapping("/index")
    public String index(){
        return "/test/index";
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/registeruser")
    public String registerUser(@RequestBody User user) throws BusinessException {
        boolean flag = userservice.insert(user);
        if(flag){
            return success("注册成功");
        }else{
            return success("注册失败");
        }

    }



    @RequestMapping("/")
    public String login(@RequestBody User user) throws BusinessException {
        return null;
    }



    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String getUserById(@PathVariable("id") String id){
        User user = userservice.getUserById(id);
        System.out.println(user);
        return "";
    }
}
