package com.gridpoint.energy.util.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class SimpleProfileStatsHolder {
    public static SimpleMethodProfileStats getInstance() {
        return( Holder.instance );
    }
    private static final class Holder {
        private static final SimpleMethodProfileStats instance;

        static {
            ApplicationContext context = new ClassPathXmlApplicationContext("simpleProfileStatsHolder-context.xml");
            instance = (SimpleMethodProfileStats)context.getBean("simpleMethodProfileStats");
        }
    }
}
