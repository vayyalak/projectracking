package com.gridpoint.energy.util.logging;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.apache.log4j.Logger;

/**
 * Aspect which wraps a method call and logs the input parameters
 * as well as the result from the method.
 *
 * The following will need to be present in the application-context.xml
 * file to make this work:<br/>
 * &lt;aop:aspectj-autoproxy/&gt;<br/>
 * &lt;bean class="com.gridpoint.energy.utils.logging.MethodLogger"/&gt;<br/>
 * and log4j must be configured with TRACE logging enabled for the target class.
 */
@Aspect
public class MethodLogger {

    /**
     * Gets a Logger for the target class.
     * @param jp identifes the target being logged.
     * @return the {@link Logger} for the target class.
     */
    private static Logger getLogger(JoinPoint jp) {
        // N.B. we get a logger for the /target/ class, not this MethodLogger class,
        // because the log message is relevant to the target class, not this one.
        return Logger.getLogger(jp.getSignature().getDeclaringType());
    }

    /**
     * Gets the target method's name and parameter values.
     * @param jp
     *          identifies the target method.
     * @return
     *          the target method's name and string representations of its parameter values.
     */
    private static String getMethodNameAndParams(JoinPoint jp) {
        // Get the method name.
        StringBuilder message = new StringBuilder();
        message.append(jp.getSignature().getName());
        message.append("(");

        // Append each parameter's value.
        boolean first = true;
        for (Object o : jp.getArgs()) {
            if (first) {
                first = false;
            } else {
                message.append(", ");
            }
            message.append(( o instanceof Object [] ) ?
                // If the parameter is an array, then log each element separately.
                Arrays.toString((Object []) o) :
                o);
        }
        message.append(")");

        return message.toString();
    }

    // Pointcuts

    /**
     * For any method annotated with the {@link LogMethodDetails} annotation,
     * this pointcut method logs the method name, parameters,
     * and return value as a debug-level log4j entry.
     * @param pjp
     *          identifies the target method
     * @return  the return value of the target method
     * @throws Throwable
     *          the target method threw an exception
     */
    @Around("@annotation(com.gridpoint.energy.util.logging.LogMethodDetails)")
    public Object logMethodDetailsPointCut(ProceedingJoinPoint pjp) throws Throwable {
        return logMethodDetailsAround(pjp);
    }

    // Advice

    /**
     * Logs the method name, parameters, and return value as a TRACE-level log4j entry.
     * This is an AOP "around" advice method.
     * @param pjp
     *          identifies the target method
     * @return  the return value of the target method
     * @throws Throwable
     *          the target method threw an exception
     */
    public Object logMethodDetailsAround(ProceedingJoinPoint pjp) throws Throwable {
        // this effectively a noop if logging is not enabled, so we'll
        // test up front and save ourselves some work.
        Logger log = getLogger(pjp);
        if (!log.isTraceEnabled()) {
            return pjp.proceed();
        }

        // Log the method name and parameters.
        String message = getMethodNameAndParams(pjp);

        // Log the return value.
        Object value = pjp.proceed();
        log.trace(message + " returned " + String.valueOf(value));
        return value;
    }

    /**
     * Logs the method name, and parameters as a TRACE-level log4j entry.
     * This is an AOP "before" advice method.
     * @param jp
     *          identifies the target method
     */
    public void logMethodDetailsBefore(JoinPoint jp) {

        Logger log = getLogger(jp);
        if (!log.isTraceEnabled()) {
            return;
        }

        // Log the method name and parameters.
        String message = getMethodNameAndParams(jp);
        log.trace(message);
    }
}
