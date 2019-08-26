package com.cheng.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author chengwei
 * @date 2019-08-26 15:24
 */
@Controller
public class HelloJspController {
    @RequestMapping("/helloJsp")
    public String helloJsp(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "helloJsp";

    }
}
