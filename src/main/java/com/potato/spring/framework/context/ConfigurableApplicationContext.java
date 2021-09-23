package com.potato.spring.framework.context;

import com.potato.spring.framework.beans.BeansException;

/**
 * @author potato
 * @date 2021/9/23 10:24 下午
 * @blame
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
