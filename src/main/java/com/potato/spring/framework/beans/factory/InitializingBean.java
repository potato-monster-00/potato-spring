package com.potato.spring.framework.beans.factory;

/**
 * @author potato
 * @date 2021/9/25 4:36 下午
 * @blame
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
