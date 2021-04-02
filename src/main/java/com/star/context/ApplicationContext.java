package com.star.context;

import com.star.beans.factory.HierarchicalBeanFactory;
import com.star.beans.factory.ListableBeanFactory;
import com.star.core.io.ResourceLoader;

/**
 * 继BeanFactory之外的另一个核心接口 允许容器通过应用程序上下文环境创建、获取、管理bean。为应用程序提供配置的中央接口
 *
 * @Author: zzStar
 * @Date: 04-02-2021 20:44
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
