package com.xxw.controller;

import com.xxw.pojo.User;
import com.xxw.service.IUserService;
import com.xxw.util.LoggerAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Resource(name = "IUserService")
    private IUserService service;
    @Resource(name = "UserServiceImplement")
    private IUserService userService;


    /*@RequestMapping(value = "getUserList")
    public ModelAndView getUserList(String id) {
        logger.info("查询用户列表信息");
        ModelAndView mv = new ModelAndView();
        List<User> list = null;
        try {
            list = service.getUserList(id);
            mv.setViewName("userList");
            mv.addObject("listUser", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }*/

    @RequestMapping(value = "getUserName", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserName(){
        logger.info("查询用户名");
        try{
            return userService.getUserName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
