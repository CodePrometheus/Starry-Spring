package com.star.ioc;

import com.star.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 04-03-2021 11:25
 */
public class InitAndDestroyMethodTest {

    @Test
    public void testInitAndDestroyMethod() {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        xmlApplicationContext.registerShutdownHook();
    }

}
