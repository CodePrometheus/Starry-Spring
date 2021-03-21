package com.star.beans.factory.config;

import com.star.beans.PropertyValues;

/**
 * 兵马未动，Definition先行， BeanDefinition就是SpringBean的建模对象
 * BeanDefinition描述和定义了创建一个Bean需要的所有信息，属性，构造函数参数以及访问它们的方法。还有其他一些信息，比如这些定义来源自哪个类等等信息；
 * 可以这么说，把Bean看做一个物体，BeanDefinition就是用来定义和描述物体材质，形状、颜色、大小等属性的一个东西，有着各种各样的物体需要描述，于是就产生了很多个BeanDefinition
 *
 * @Author: zzStar
 * @Date: 03-20-2021 13:10
 */
public class BeanDefinition {

    /**
     * 先简化为class类型
     */
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
