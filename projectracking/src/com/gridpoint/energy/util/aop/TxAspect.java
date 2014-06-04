package com.gridpoint.energy.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TxAspect {

    /**
     */
    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object result(ProceedingJoinPoint pjp) throws Throwable {
        try {
	    System.out.println("************************** before tx ***********************");
            return pjp.proceed();
	} finally {
	    System.out.println("************************** after tx ***********************");
        }
    }
}
