package com.xxw.service.impl;

import com.xxw.dao.UserDao;
import com.xxw.pojo.User;
import com.xxw.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "IUserService")
public class UserServiceImpl  implements IUserService {

    @Resource(name = "UserDao")
    private UserDao dao;


    @Override
    public List<User> getUserList(String id)throws Exception {
       return dao.findUserListById(id);
    }

}
