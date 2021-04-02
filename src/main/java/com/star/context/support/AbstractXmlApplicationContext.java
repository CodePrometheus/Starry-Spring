package com.star.context.support;

import com.star.beans.BeansException;
import com.star.beans.factory.support.DefaultListableBeanFactory;
import com.star.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 实现loadBeanDefinitions里的loadBeanDefinitions
 *
 * @Author: zzStar
 * @Date: 04-02-2021 21:55
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * getConfigLocations交由子类去实现
     *
     * @return
     */
    protected abstract String[] getConfigLocations();

}
