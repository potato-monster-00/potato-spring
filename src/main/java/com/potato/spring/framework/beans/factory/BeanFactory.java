package com.potato.spring.framework.beans.factory;

import com.potato.spring.framework.beans.BeanException;

/**
 * @author potato
 * @date 2021/9/19 1:54 下午
 * @blame
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;
}