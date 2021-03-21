package com.star.beans.factory;

import com.star.beans.PropertyValue;
import com.star.beans.PropertyValues;
import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.service.SpringService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void testBeanPropertyValues() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("zzStar", "love u"));
        propertyValues.addPropertyValue(new PropertyValue("starry", "handsome boy"));

        BeanDefinition beanDefinition = new BeanDefinition(SpringService.class, propertyValues);
        beanFactory.registerBeanDefinition("springService", beanDefinition);

        SpringService springService = (SpringService) beanFactory.getBean("springService");
        System.out.println(springService.toString());

        System.out.println(assertThat(springService.getZzStar()).isEqualTo("love u"));
        System.out.println(assertThat(springService.getStarry()).isEqualTo("handsome boy"));
    }

}
