package com.star.beans.factory.config;

/**
 * 一个Bean对另一个Bean的引用
 *
 * @Author: zzStar
 * @Date: 03-22-2021 21:44
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
