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
    UserService userService;

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
        boolean flag = userService.insert(user);
        if(flag){
            return success("注册成功");
        }else{
            return success("注册失败");
        }
    }

    /**
     * 用户登录
     * @param user
     * @return
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody User user) throws BusinessException {
        boolean flag =false;
        if(user!=null){
            flag = userService.login(user);
        }else{
            throw new BusinessException("登录异常");
        }
        if(flag){
            return success("登录成功");
        }else{
            return error("登录失败");
        }
    }

    /**
     * 用户登出
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(){
        if(userService.logout()){
            return success("用户已退出");
        }else{
            return error("退出失败");
        }
    }

    /**
     * 用户资料
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        System.out.println(user);
        return "";
    }
}
