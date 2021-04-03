package com.star.beans.factory;

/**
 * @Author: zzStar
 * @Date: 04-03-2021 10:05
 */
public interface DisposableBean {

    /**
     * 销毁Bean
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
