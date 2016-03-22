package com.cristik.framework.interceptor;


import com.cristik.framework.base.SessionHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(SessionHelper.isLogin()){
			return true;
		}else{
			//http://localhost:8060/springdemo/user/list?id=3&tomcat=4&lili=5&id=444
			String context = request.getContextPath();
			String uri = request.getRequestURI();
			String url = StringUtils.substring(uri,context.length());
			String condition = "";
			Map map = request.getParameterMap();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry = (Map.Entry)iterator.next();
				String key = (String)entry.getKey();
				String[] values = (String[])entry.getValue();
				for(String value : values){
					if(condition.length()!=0){
						condition+="&"+key+"="+value;
					}else{
						condition+=key+"="+value;
					}
				}
			}
			if(condition.length()>0){
				url=url+"?"+condition;
			}
			String params = URLEncoder.encode(url,"utf-8");
			response.sendRedirect(request.getContextPath()+"/user/tologin?params="+params);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}


}
