package com.star.ioc.common;

import com.star.beans.BeansException;
import com.star.beans.Beer;
import com.star.beans.factory.config.BeanPostProcessor;


/**
 * @Author: zzStar
 * @Date: 03-28-2021 22:03
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization, beanName: " + beanName);
        if ("beer".equals(beanName)) {
            ((Beer) bean).setTsingTao("Budweiser");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
