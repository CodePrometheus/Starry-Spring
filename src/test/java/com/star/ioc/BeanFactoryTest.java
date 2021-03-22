package com.star.ioc;

import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.service.SpringService;
import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 03-20-2021 12:59
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        System.out.println(beanFactory);
        BeanDefinition beanDefinition = new BeanDefinition(SpringService.class);
        System.out.println(beanDefinition);
        beanFactory.registerBeanDefinition("springService", beanDefinition);

        SpringService springService = (SpringService) beanFactory.getBean("springService");
        springService.saySpring();
    }

}
