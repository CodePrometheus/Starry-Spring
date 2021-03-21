package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

/**
 * CglibSubclassingInstantiationStrategy继承了SimpleInstantiationStrategy新增了方法注入方式根据cglib生成代理类实例化方法
 *
 * @Author: zzStar
 * @Date: 03-21-2021 16:47
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    /**
     * 使用CGLIB动态生成子类
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        throw new UnsupportedOperationException("CGLIB instantiation strategy is not supported");
    }
}
