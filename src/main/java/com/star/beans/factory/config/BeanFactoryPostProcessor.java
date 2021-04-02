package com.star.beans.factory.config;

import com.star.beans.BeansException;
import com.star.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactory后置处理器，是对BeanDefinition对象进行修改
 * Spring允许BeanFactoryPostProcessor在容器实例化任何其它bean 之前 读取配置元数据，并可以根据需要进行修改，
 * 例如可以把bean的scope从singleton改为prototype，也可以把property的值给修改掉。可以同时配置多个BeanFactoryPostProcessor，并通过设置’order’属性来控制各个BeanFactoryPostProcessor的执行次序
 * BeanFactoryPostProcessor 为spring在容器初始化时对外对外暴露的扩展点，Spring IoC容器允许BeanFactoryPostProcessor在容器加载注册BeanDefinition完成之后读取BeanDefinition(配置元数据)，并可以修改它
 *
 * @Author: zzStar
 * @Date: 03-28-2021 20:08
 */
public interface BeanFactoryPostProcessor {


    /**
     * 在所有BeanDefinition加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
