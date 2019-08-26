package com.cheng.springboot.service.impl;

import com.cheng.springboot.dao.UserDao;
import com.cheng.springboot.model.User;
import com.cheng.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengwei
 * @date 2019-08-26 16:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }
}
