package com.cheng.springboot.controller;

import com.cheng.springboot.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengwei
 * @date 2018/11/26 下午4:54
 */
@RestController
public class HelloController {
    @Autowired
    private StudentProperties studentProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello Spring Boot test!";
    }

    @RequestMapping("/name")
    public String name() {
        return studentProperties.getName() + ":" + studentProperties.getAge();
    }
}
