package com.potato.spring.framework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.potato.spring.framework.beans.factory.config.BeanDefinition;
import com.potato.spring.framework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author potato
 * @date 2021/9/30 10:47 下午
 * @blame
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
