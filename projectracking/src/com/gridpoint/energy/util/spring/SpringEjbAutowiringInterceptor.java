package com.gridpoint.energy.util.spring;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;


public class SpringEjbAutowiringInterceptor extends SpringBeanAutowiringInterceptor{

    @Override
    protected BeanFactoryLocator getBeanFactoryLocator(Object target) {
        String resourceLocation = "classpath*:" + target.getClass().getSimpleName() + "-beanRefContext.xml";

        System.out.println("Resource Location: " + resourceLocation );

        return ContextSingletonBeanFactoryLocator.getInstance(resourceLocation);
    }

}
