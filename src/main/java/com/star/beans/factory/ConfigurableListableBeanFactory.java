package com.star.beans.factory;

import com.star.beans.BeansException;
import com.star.beans.factory.config.AutowireCapableBeanFactory;
import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.config.BeanPostProcessor;
import com.star.beans.factory.config.ConfigurableBeanFactory;

/**
 * 实现ListableBeanFactory & AutowireCapableBeanFactory & ConfigurableBeanFactory
 * 提供bean definition的解析,注册功能,再对单例来个预加载(解决循环依赖问题),实现对工厂的配置以及对bean属性的自动装配
 *
 * @Author: zzStar
 * @Date: 03-27-2021 22:28
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据beanName查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * beanPostProcessor
     *
     * @param beanPostProcessor
     */
    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
