package com.cristik.business.controller;

import com.cristik.business.entity.svo.Signature;
import com.cristik.business.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhenghua on 2016/3/30.
 */
@Controller
@RequestMapping("/signature")
public class SignatureController {
    @Autowired
    SignatureService signatureService;


    @RequestMapping("/test")
    public String toTest(){
        return "/test/signature";
    }

    @RequestMapping("/insert")
    public String insert(Signature signature){
        int id = signatureService.insertSignature(signature);
        System.out.println(id);
        return "redirect:/signature/test";
    }



}
