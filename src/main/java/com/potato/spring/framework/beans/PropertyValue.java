package com.potato.spring.framework.beans;

/**
 * @author potato
 * @date 2021/9/21 9:16 下午
 * @blame
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
