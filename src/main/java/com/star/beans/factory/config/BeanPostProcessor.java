package com.star.beans.factory.config;

import com.star.beans.BeansException;

/**
 * 用于修改实例化后的bean的修改扩展点
 * 在Bean对象在实例化和依赖注入完毕后，在显示调用初始化方法的前后添加我们自己的逻辑。
 * 注意是Bean实例化完毕后及依赖注入完成后触发的
 *
 * @Author: zzStar
 * @Date: 03-28-2021 20:13
 */
public interface BeanPostProcessor {

    /**
     * 在bean执行初始化方法之前执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * 在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
