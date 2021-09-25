package com.potato.spring.framework.context;

import com.potato.spring.framework.beans.BeansException;
import com.potato.spring.framework.beans.factory.Aware;

/**
 * @author potato
 * @date 2021/9/25 8:54 下午
 * @blame
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
