package com.gridpoint.energy.util.jndi;

import org.springframework.web.context.ServletContextAware;
import javax.servlet.ServletContext;

public class ContextAwareBean implements ServletContextAware, ServletContextProvider {
    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public ServletContext getServletContext(){
        return servletContext;
    }

}
