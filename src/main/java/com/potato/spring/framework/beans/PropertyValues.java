package com.potato.spring.framework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author potato
 * @date 2021/9/21 9:18 下午
 * @blame
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return propertyValueList.stream()
                .filter(pv -> pv.getName().equals(propertyName))
                .findAny()
                .orElse(null);
    }

}
