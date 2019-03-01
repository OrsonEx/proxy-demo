package com.rambo.proxy.demo;

/**
 * 用户服务抽象
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param pwd      密码
     * @return 登陆结果
     */
    String login(String userName, String pwd);
}
