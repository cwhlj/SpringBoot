package com.cheng.springboot.dao;

import com.cheng.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengwei
 * @date 2019-08-26 16:08
 */
@Mapper
@Repository
public interface UserDao {
    List<User> queryUserList();
}
