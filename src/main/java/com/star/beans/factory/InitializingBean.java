package com.star.beans.factory;

/**
 * @Author: zzStar
 * @Date: 04-03-2021 10:05
 */
public interface InitializingBean {

    /**
     * 初始化bean的时候执行，可以针对某个具体的bean进行配置
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
