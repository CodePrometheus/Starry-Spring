package com.star.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.star.beans.BeansException;
import com.star.beans.factory.DisposableBean;
import com.star.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * 实现一次性Bean和可运行接口适配器，对给定Bean实例执行各种销毁步骤
 *
 * @Author: zzStar
 * @Date: 04-03-2021 10:14
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 避免同时继承自DisposableBean，且自定义方法与DisposableBean方法同名，销毁方法执行两次的情况
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            // 执行自定义方法
            Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if (destroyMethod == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
