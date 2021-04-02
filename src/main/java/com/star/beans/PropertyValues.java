package com.star.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含一个或多个PropertyValue对象的容器，通常包含特定目标bean的一个更新
 *
 * @Author: zzStar
 * @Date: 03-21-2021 17:08
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentValue = this.propertyValueList.get(i);
            if (currentValue.getName().equals(propertyValue.getName())) {
                // 覆盖
                this.propertyValueList.set(i, propertyValue);
                return;
            }
        }
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue propertyValue = this.propertyValueList.get(i);

            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

}
