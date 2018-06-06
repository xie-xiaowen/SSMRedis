package com.xxw.service.impl;

import com.xxw.dao.UserDao;
import com.xxw.pojo.User;
import com.xxw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "UserServiceImplement")
public class UserServiceImplement implements IUserService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserDao userDao;

    @Override
    public List<String> getUserName() throws Exception {
        String key = "usernames";  // redis中存储所有用户名的key
        List<String> usernames;    // 存储所有用户名
        // 如果不为空，读取redis中用户名，否则 到数据库取所有用户名存储到redis
        if(redisTemplate.opsForList().size(key) > 0){
            usernames = redisTemplate.opsForList().range(key, 0, -1);
        }else{
            usernames = userDao.findUserNameAll();
            redisTemplate.opsForList().leftPushAll(key, usernames);
        }
        return usernames;
    }

    @Override
    public List<User> getUserList(String id) throws Exception {
        return null;
    }

}
