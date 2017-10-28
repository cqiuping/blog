package com.boot.test.demo.controller;

import com.boot.test.demo.entity.User;
import com.boot.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/allUser")
    public List<User> allUser(){
        return userService.findAllUsers();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello，world";
    }
}
