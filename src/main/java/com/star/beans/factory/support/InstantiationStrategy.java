package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

/**
 * Bean实例化策略
 * <p>
 * BeanDefinition加入到注册中，并由BeanFactoryPostProcessor的实现类处理后，
 * 需要由InstantiationStrategy负责实例化。
 * 实例化仅仅是调用构造函数，相当于new了一个对象而已，bean的具体的属性在此时并未赋值 。
 * InstantiationStrategy负责由Bean类的默认构造函数、带参构造函数或者工厂方法等来实例化Bean。
 *
 * @Author: zzStar
 * @Date: 03-21-2021 16:36
 */
public interface InstantiationStrategy {

    /**
     * 默认构造方法
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
