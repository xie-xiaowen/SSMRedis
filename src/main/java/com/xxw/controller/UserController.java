package com.xxw.controller;

import com.xxw.pojo.User;
import com.xxw.service.IUserService;
import com.xxw.util.LoggerAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Resource(name = "IUserService")
    private IUserService service;

    @RequestMapping(value = "getUserList")
    @ResponseBody
    public Object getUserList(String id) {
        logger.info("查询用户列表信息");
        List<User> list = null;
        try {
            list = service.getUserList(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
