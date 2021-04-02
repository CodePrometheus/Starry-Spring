package com.star.context;

import com.star.beans.BeansException;

/**
 * @Author: zzStar
 * @Date: 04-02-2021 20:52
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
