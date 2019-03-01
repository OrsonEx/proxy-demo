package com.rambo.proxy.demo.impl;

import cn.hutool.core.lang.Console;
import com.rambo.proxy.demo.UserService;

/**
 * 用户服务实现
 *
 * @author Rambo 2019-03-01
 **/
public class UserServiceImpl implements UserService {


    @Override
    public String login(String userName, String pwd) {
        Console.log("进行登陆逻辑.........");

        return "登陆结果";
    }
}