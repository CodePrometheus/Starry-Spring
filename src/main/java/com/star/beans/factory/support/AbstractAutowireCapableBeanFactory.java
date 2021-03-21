package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

/**
 * 提供bean的创建 (有construct方法), 属性注值, 绑定 (包括自动绑定)和初始化.
 * <p>
 * 处理运行时bean引用, 解析管理的集合, 调用初始化方法。
 * 继承AbstractBeanFactory
 *
 * @Author: zzStar
 * @Date: 03-20-2021 14:07
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();


    /**
     * 这个类的核心方法，创建一个bean实例， 填充bean实例，执行后处理等
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(beanName, beanDefinition);
    }

    /**
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            // bean = beanClass.newInstance(); 仅适用于bean有无参构造函数的情况
            bean = createBeanInstance(beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}
