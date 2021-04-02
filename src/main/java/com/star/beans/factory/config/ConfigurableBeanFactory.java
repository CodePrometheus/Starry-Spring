package com.star.beans.factory.config;

import com.star.beans.factory.BeanFactory;

/**
 * 定义BeanFactory的配置
 *
 * @Author: zzStar
 * @Date: 03-28-2021 20:17
 */
public interface ConfigurableBeanFactory extends BeanFactory, SingletonBeanRegistry {

    /**
     * 注册进IOC
     *
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
