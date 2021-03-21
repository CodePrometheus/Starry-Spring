package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.BeanFactory;
import com.star.beans.factory.config.BeanDefinition;

/**
 * 继承SingletonBeanRegistry的实现类DefaultSingletonBeanRegistry
 * 同时实现BeanFactory接口
 *
 * @Author: zzStar
 * @Date: 03-20-2021 13:30
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    /**
     * 实现BeanFactory中的getBean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }


    /**
     * 创建Bean
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取Bean信息
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
