package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/hellow")
    public String test(){
        System.out.println("收到了请求");
        return "success";
    }
}

