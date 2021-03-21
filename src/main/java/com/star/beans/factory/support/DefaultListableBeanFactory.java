package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory 定义了容器的基础概念、接口方法等，但是 DefaultListableBeanFactory 才是一个真正可以 new 出来的具体的容器，当然也可以暂且称之为 bean 工厂
 * 实现了BeanDefinitionRegistry接口用来保存bean定义，继承了AbstractAutowireCapableBeanFactory用来支撑autowired
 * <p>
 * 继承AbstractAutowireCapableBeanFactory以及实现BeanDefinitionRegistry
 *
 * @Author: zzStar
 * @Date: 03-20-2021 14:25
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
