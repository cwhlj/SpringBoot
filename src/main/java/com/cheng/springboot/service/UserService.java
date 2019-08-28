package com.cheng.springboot.service;

import com.cheng.springboot.model.User;

import java.util.List;

/**
 * @author chengwei
 * @date 2019-08-26 16:05
 */
public interface UserService {
    List<User> queryUserList();

    boolean login(String userName, String password);
}
