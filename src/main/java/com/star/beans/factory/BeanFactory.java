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


}
