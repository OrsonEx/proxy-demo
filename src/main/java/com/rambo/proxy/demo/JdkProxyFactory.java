package com.rambo.proxy.demo;

import cn.hutool.core.lang.Console;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类
 *
 * @author Rambo 2019-03-01
 **/
public class JdkProxyFactory {

    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Console.log("执行目标前的扩展......");
                Object returnValue = method.invoke(target, args);
                Console.log("执行目标后的扩展......");
                return returnValue;
            }
        });
    }
}