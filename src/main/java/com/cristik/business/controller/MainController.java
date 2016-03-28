package com.cristik.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhenghua on 2016/3/11.
 */

@Controller
@RequestMapping("/main")
public class MainController {


	@RequestMapping("/")
	public String index(){
		System.out.println("here is the welcome page");
		System.out.println(111);
		return "index";
	}

	@RequestMapping("/test")
	public String test(){
		return "/test/test";
	}
}
