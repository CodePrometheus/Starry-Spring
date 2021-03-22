package com.star.core.io;

/**
 * 资源查找定位策略的抽象
 *
 * @Author: zzStar
 * @Date: 03-22-2021 22:50
 */
public interface ResourceLoader {

    /**
     * 获取Resource
     *
     * @param location
     * @return
     */
    Resource getResource(String location);

}
