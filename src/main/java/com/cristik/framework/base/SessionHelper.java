package com.cristik.framework.base;

import com.cristik.business.entity.svo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhenghua on 2016/3/22.
 */
public class SessionHelper {

    public static HttpSession getSession(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static void put(User user){
        HttpSession session = getSession();
        session.setAttribute("user",user);
    }

    public static void remove(){
        HttpSession session = getSession();
        session.removeAttribute("user");
    }

    public static boolean isLogin(){
        HttpSession session = getSession();
        Object obj = session.getAttribute("user");
        if(obj!=null){
            return true;
        }else{
            return false;
        }
    }

}
