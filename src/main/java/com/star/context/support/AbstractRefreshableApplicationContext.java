package com.star.context.support;

import com.star.beans.BeansException;
import com.star.beans.factory.support.DefaultListableBeanFactory;

/**
 * 继承AbstractApplicationContext，为refreshBeanFactory方法提供了一个逻辑实现——如果已有beanFactory刷新过了，则先关闭它，
 * 然后重建一个，并且为它加载bean定义。它提供了一个loadBeanDefinitions方法给子类实现。至于子类从哪加载，如何加载，并不过问。
 *
 * @Author: zzStar
 * @Date: 04-02-2021 21:49
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected final void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 加载BeanDefinition
     * 这个类仍然没有说明configLocations应该是什么，从代码来看，它仅仅只是个字符串数组
     * AbstractXmlApplicationContext实现
     *
     * @param beanFactory
     * @throws BeansException
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;


    /**
     * 创建Bean工厂
     *
     * @return
     */
    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

}
