package com.star.beans.factory;

import com.star.beans.BeansException;

/**
 * Bean 工厂
 *
 * @Author: zzStar
 * @Date: 03-20-2021 12:14
 */
public interface BeanFactory {

    /**
     * 获取Bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;


    /**
     * 根据名称和类型查找Bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
