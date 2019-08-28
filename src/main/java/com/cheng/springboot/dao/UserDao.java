package com.cheng.springboot.dao;

import com.cheng.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengwei
 * @date 2019-08-26 16:08
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * queryUserList
     *
     * @return
     */
    List<User> queryUserList();

    /**
     * login
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);
}
