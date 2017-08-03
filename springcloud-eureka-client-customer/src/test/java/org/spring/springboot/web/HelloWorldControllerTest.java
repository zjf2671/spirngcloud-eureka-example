package org.spring.springboot.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Description: Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
public class HelloWorldControllerTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello,World!",new HelloWorldController().sayHello());
    }
}
