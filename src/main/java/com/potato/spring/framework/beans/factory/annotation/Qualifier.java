package com.potato.spring.framework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author potato
 * @date 2021/10/4 10:54 上午
 * @blame
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
