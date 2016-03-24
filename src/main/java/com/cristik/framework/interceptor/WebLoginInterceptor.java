package com.cristik.framework.interceptor;


import com.cristik.framework.base.SessionHelper;
import com.cristik.framework.util.ParamsUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否是web路径
        if(!StringUtils.substring(request.getRequestURI(),request.getContextPath().length()).startsWith("/api")){
            if (SessionHelper.isLogin()) {
                return true;
            } else {
                String params = ParamsUtils.storeParams(request);
                response.sendRedirect(request.getContextPath() + "/user/tologin?params=" + params);
                return false;
            }
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
