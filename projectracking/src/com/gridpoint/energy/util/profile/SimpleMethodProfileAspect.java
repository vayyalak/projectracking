package com.gridpoint.energy.util.profile;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Simple Profiler used for trending.
 * Activated by annotating a method with @SimpleProfile
 * For a more complete / enterprisey / expensive solution see: http://www.jinspired.com/
 * Advice applied to @SimpleMethodProfile
 */
@Aspect
public class SimpleMethodProfileAspect
{
    //@Autowired
    //private final ProfileStats profileStats = null;
    //BUGBUG TODO: we are using this old style singleton instead of Spring because of JEE issues.
    private static final ProfileStats profileStats = SimpleProfileStatsHolder.getInstance();


    @Around("@annotation(com.gridpoint.energy.util.profile.SimpleMethodProfile) && within(com.gridpoint..*)")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        if( profileStats != null ) {

            String  methodName  = pjp.getSignature().getDeclaringType().getName() + "." + pjp.getSignature().getName();
            long    start       = System.currentTimeMillis();
            Object  retVal      = pjp.proceed();
            long    end         = System.currentTimeMillis();

            profileStats.logCall( methodName, (int)(end - start) );

            return retVal;
        } else {
            //If not properly configured (No SimpleMethodProfileStats).. just silently continue.
            return( pjp.proceed() );
        }
    }

}

