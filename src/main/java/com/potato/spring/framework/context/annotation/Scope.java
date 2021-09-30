package com.potato.spring.framework.context.annotation;

import java.lang.annotation.*;

/**
 * @author potato
 * @date 2021/9/30 10:42 下午
 * @blame
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
