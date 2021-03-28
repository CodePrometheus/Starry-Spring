package com.star.beans.factory;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

/**
 * 实现ListableBeanFactory
 *
 * @Author: zzStar
 * @Date: 03-27-2021 22:28
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory {

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

}
