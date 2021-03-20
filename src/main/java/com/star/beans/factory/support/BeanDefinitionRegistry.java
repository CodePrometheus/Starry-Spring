package com.star.beans.factory.support;

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
}
