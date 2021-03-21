package com.star.beans.factory.config;

import com.star.util.Nullable;

/**
 * 单例Bean的注册中心 顶级接口
 *
 * @Author: zzStar
 * @Date: 03-20-2021 13:32
 */
public interface SingletonBeanRegistry {

    /**
     * 在给定的bean名称下，在bean注册表中将给定的现有对象注册为singleton
     *
     * @param beanName        the name of the bean
     * @param singletonObject the existing singleton object
     */
//    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 返回在给定名称下注册的（原始）单例对象
     *
     * @param beanName
     * @return
     */
    @Nullable
    Object getSingleton(String beanName);
}
