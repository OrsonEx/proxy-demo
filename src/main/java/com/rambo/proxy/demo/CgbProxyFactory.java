package com.rambo.proxy.demo;

import cn.hutool.core.lang.Console;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 动态代理工厂
 *
 * @author Rambo 2019-03-01
 **/
public class CgbProxyFactory implements MethodInterceptor {

    private Object target;

    public CgbProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Console.log("执行目标前的扩展......");
        Object returnValue = method.invoke(target, args);
        Console.log("执行目标后的扩展......");
        return returnValue;
    }
}