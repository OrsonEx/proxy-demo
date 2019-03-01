package com.rambo.proxy.demo;

import com.rambo.proxy.demo.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserServiceProxy Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2019</pre>
 */
public class UserServiceProxyTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: login(String userName, String pwd)
     */
    @Test
    public void testLogin() throws Exception {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.login("user1","123");
    }
}
