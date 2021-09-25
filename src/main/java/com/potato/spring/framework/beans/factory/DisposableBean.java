package com.potato.spring.framework.beans.factory;

/**
 * @author potato
 * @date 2021/9/25 4:37 下午
 * @blame
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
