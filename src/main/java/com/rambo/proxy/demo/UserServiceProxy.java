package com.rambo.proxy.demo;

import cn.hutool.core.lang.Console;

/**
 * 用户服务代理类
 *
 * @author Rambo 2019-03-01
 **/
public class UserServiceProxy implements UserService {
    private UserService userService;

    UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String login(String userName, String pwd) {
        Console.log("登陆前扩展.....");
        userService.login(userName, pwd);
        Console.log("登陆后扩展.....");
        return "登陆结果";
    }
}