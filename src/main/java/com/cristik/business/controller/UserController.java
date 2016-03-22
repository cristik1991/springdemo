package com.cristik.business.controller;

import com.cristik.business.entity.svo.User;
import com.cristik.framework.exception.BusinessException;
import com.cristik.framework.base.BaseController;
import com.cristik.business.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhenghua on 2016/3/10.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    protected static Logger logger = Logger.getLogger(Controller.class);

    @Autowired
    UserService userService;

    /**
     *
     * 查询所有用户列表
     */
    @RequestMapping("/list")
    public String getUserList( ModelMap model){
        List<User> list = userService.getUserList();
        model.put("list",list);
        return "/user/userlist";
    }

    /**
     *分页查询用户信息
     */
    @RequestMapping("/pagelist")
    public String getUserListByPage(ModelMap model){
        return "/user/userpage";
    }

    /*
     *查询用户详情
     */
    @RequestMapping("/detail")
    public String getUserById(String id, ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "/user/userdetail";
    }

    /*
     *跳转到新增用户
     */
    @RequestMapping("/toadduser")
    public String toAddUser(){
        return "/user/adduser";
    }

    /*
     *新增用户
     */
    @RequestMapping("/adduser")
    public String addUser(User user)throws BusinessException{
        userService.insert(user);
        return "redirect:/user/list";
    }

    /*
     *删除用户
     * produces = "text/html;charset=UTF-8"解决返回json中文乱码
     *
     */
    @ResponseBody
    @RequestMapping(value="/deleteuser")
    public String deleteUserById(String id, ModelMap model) {
        boolean flag = userService.deleteUser(id);
        if (flag) {
            return success("success删除成功");

        } else {
            return error("删除失败");
        }
    }

    /*
     *跳转到修改用户
     */
    @RequestMapping("/toupdateuser")
    public String toUpdateUser(String id,ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "/user/updateuser";
    }

    /*
     *修改用户
     */
    @RequestMapping("/updateuser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/list";
    }


}
