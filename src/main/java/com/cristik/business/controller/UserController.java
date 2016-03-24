package com.cristik.business.controller;

import com.cristik.business.entity.svo.User;
import com.cristik.framework.exception.BusinessException;
import com.cristik.framework.base.BaseController;
import com.cristik.business.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
     * 跳转到新增用户
     * @return
     */
    @RequestMapping("/toregister")
    public String toRegisterUser(){
        return "/user/userregister";
    }

    /**
     * 用户注册
     * @param user
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/rigister")
    public String registerUser(User user)throws BusinessException{
        userService.insert(user);
        return "redirect:/user/list";
    }

    /**
     * 删除用户
     * produces = "text/html;charset=UTF-8"解决返回json中文乱码
     * @param id
     * @param model
     * @return
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

    /**
     * 跳转到修改用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdateuser")
    public String toUpdateUser(String id,ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "/user/updateuser";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/updateuser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/tologin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response,ModelMap model){
        String params = request.getParameter("params");
        if(StringUtils.isNotBlank(params)){
            try {
                params = URLDecoder.decode(params,"utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("登录拦截跳转参数异常",e);
            }
        }
        System.out.println(params);
        model.put("url",params);
        return "/user/login";
    }

    /**
     * 查询所有用户列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String getUserList( ModelMap model){
        List<User> list = userService.getUserList();
        model.put("list",list);
        return "/user/userlist";
    }

    /**
     * 分页查询用户信息
     * @param model
     * @return
     */
    @RequestMapping("/pagelist")
    public String getUserListByPage(ModelMap model){
        return "/user/userpage";
    }

    /**
     * 查询用户详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String getUserById(String id, ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "/user/userdetail";
    }
}
