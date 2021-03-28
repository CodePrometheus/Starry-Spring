package com.star.beans.factory;

import com.star.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory接口是BeanFactory接口的一个扩展
 * ListableBeanFactory可以枚举它们的所有bean信息，而不用一个个通过bean的名称或类型一个个查找
 * 定义了访问容器中 Bean 基本信息的若干方法，如查看Bean 的个数、获取某一类型 Bean 的配置名、查看容器中是否包括某一 Bean 等方法
 *
 * @Author: zzStar
 * @Date: 03-27-2021 22:09
 */
public interface ListableBeanFactory extends BeanFactory {


    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
