package com.star.beans.factory;

/**
 * 第三个继承BeanFactory
 * 所有要应用到有层级体系的容器类（有父BeanFactory的那种），都应该实现此接口
 * 扩展了父类容器的方法，比如对父容器的获取 提供父容器的访问功能
 *
 * 另外两个为AutowireCapableBeanFactory & ListableBeanFactory
 *
 * @Author: zzStar
 * @Date: 04-02-2021 20:24
 */
public interface HierarchicalBeanFactory extends BeanFactory{
}
