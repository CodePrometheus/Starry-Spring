package com.star.beans.factory.config;

import com.star.beans.factory.HierarchicalBeanFactory;

/**
 * 定义BeanFactory的配置
 * HierarchicalBeanFactory 提供父容器的访问功能.
 * 至于父容器的设置,需要找ConfigurableBeanFactory的setParentBeanFactory(接口把设置跟获取给拆开了).
 *
 * @Author: zzStar
 * @Date: 03-28-2021 20:17
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * 注册进IOC
     *
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
