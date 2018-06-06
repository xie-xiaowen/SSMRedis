package com.xxw.dao;

import com.xxw.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "UserDao")
public class UserDao {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询全部用户信息，或根据用户ID查询用户信息
     * @param id 用户id
     * @return 用户信息
     * @throws Exception 异常
     */
    public List<User> findUserListById(String id)throws Exception{
        return sqlSessionTemplate.selectList("UserMapper.findUserList", id);
    }

    /**
     * 查询全部用户名
     * @return 用户名
     * @throws Exception 异常
     */
    public List<String> findUserNameAll()throws Exception{
        return sqlSessionTemplate.selectList("UserMapper.findUserNameAll");
    }

}
