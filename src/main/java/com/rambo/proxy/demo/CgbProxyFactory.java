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
        /*
          Enhancer类为Cglib库中的字节码增强器，它可以方便对你想要处理的类进行扩展;
          将被代理类 target 设置成父类，然后设置当前 intercept 为代理拦截器;
          最后执行 enhancer.create() 动态生成一个代理类。
         */
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