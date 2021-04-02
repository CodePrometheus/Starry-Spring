package com.star.beans.factory.config;

import com.star.beans.BeansException;
import com.star.beans.factory.BeanFactory;

/**
 * 通过多种方式创建bean，执行bean的生命周期，bean处理，依赖解决等
 *
 * @Author: zzStar
 * @Date: 03-28-2021 20:20
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;


    /**
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
