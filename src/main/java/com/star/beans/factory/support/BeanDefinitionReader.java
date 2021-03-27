package com.star.beans.factory.support;

import com.star.beans.BeansException;
import com.star.core.io.Resource;
import com.star.core.io.ResourceLoader;

/**
 * 读取bean定义信息即BeanDefinition的接口
 *
 * @Author: zzStar
 * @Date: 03-27-2021 18:46
 */
public interface BeanDefinitionReader {

    /**
     * 注册
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * xml加载
     *
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * Resource
     *
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * location
     *
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * locations
     *
     * @param locations
     * @throws BeansException
     */
    void loadBeanDefinitions(String[] locations) throws BeansException;
}
