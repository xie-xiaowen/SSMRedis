package com.xxw.service;

import com.xxw.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> getUserList(String id) throws Exception;

    List<String> getUserName() throws Exception;

}
