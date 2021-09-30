package com.potato.spring.framework.stereotype;

import java.lang.annotation.*;

/**
 * @author potato
 * @date 2021/9/30 10:45 下午
 * @blame
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
