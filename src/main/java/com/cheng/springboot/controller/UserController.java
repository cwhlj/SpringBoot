package com.cheng.springboot.controller;

import com.cheng.springboot.model.User;
import com.cheng.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chengwei
 * @date 2019-08-26 16:11
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    public String queryUserList(Model model) {
        List<User> users = userService.queryUserList();
        model.addAttribute("users", users);
        return "userList";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        return userService.login(userName, password);
    }
}
