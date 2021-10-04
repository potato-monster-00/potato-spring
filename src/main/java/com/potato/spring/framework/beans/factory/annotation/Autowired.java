package com.potato.spring.framework.beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author potato
 * @date 2021/10/4 10:53 上午
 * @blame
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface Autowired {
}
