package com.star.ioc.common;

import com.star.beans.BeansException;
import com.star.beans.PropertyValue;
import com.star.beans.PropertyValues;
import com.star.beans.factory.ConfigurableListableBeanFactory;
import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author: zzStar
 * @Date: 03-28-2021 21:59
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanFactory");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("starry");
        PropertyValues values = beanDefinition.getPropertyValues();
        // 修改
        values.addPropertyValue(new PropertyValue("name", "star"));
    }
}
