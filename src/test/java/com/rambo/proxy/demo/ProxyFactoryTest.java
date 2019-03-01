package com.rambo.proxy.demo;

import com.rambo.proxy.demo.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ProxyFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2019</pre>
 */
public class ProxyFactoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getProxyInstance()
     */
    @Test
    public void testGetProxyInstance() throws Exception {
        UserService proxyInstance = (UserService) new JdkProxyFactory(new UserServiceImpl()).getProxyInstance();
        proxyInstance.login("user1", "11111");
    }
}
