package com.star.beans;

/**
 * Bean属性信息
 * 保存单个bean属性的信息和值的对象
 *
 * @Author: zzStar
 * @Date: 03-21-2021 17:00
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
