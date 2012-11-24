package ru.grails.security

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext

class SpringUtils {

    public static ApplicationContext getCtx() {
        return getApplicationContext();
    }

    public static ApplicationContext getApplicationContext() {
        return (ApplicationContext) ServletContextHolder.getServletContext().getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT);
    }

    public static getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

}
