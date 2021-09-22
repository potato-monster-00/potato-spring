package com.potato.spring.framework.core.io;

/**
 * @author potato
 * @date 2021/9/21 11:20 下午
 * @blame
 */
public interface ResourceLoader {

    String CLASS_PATH_PREFIX = "classpath:";

    Resource getResource(String location);
}
