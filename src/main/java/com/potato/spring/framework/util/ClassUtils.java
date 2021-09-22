package com.potato.spring.framework.util;

import cn.hutool.core.util.ClassUtil;

/**
 * @author potato
 * @date 2021/9/21 11:15 下午
 * @blame
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }

        if (classLoader == null) {
            classLoader = ClassUtil.getClassLoader();
        }

        return classLoader;
    }
}
