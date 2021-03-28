package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @Author: zzStar
 * @Date: 03-20-2021 13:53
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);


    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();

}
