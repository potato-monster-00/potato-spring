package com.potato.spring.framework.context;

import com.potato.spring.framework.beans.factory.HierarchicalBeanFactory;
import com.potato.spring.framework.beans.factory.ListableBeanFactory;
import com.potato.spring.framework.core.io.ResourceLoader;

/**
 * @author potato
 * @date 2021/9/23 10:24 下午
 * @blame
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
