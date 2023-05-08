package com.sl.revision.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//@Before("execution(* com.sl.revision.demo.aop.ShoppingCart.checkout(..))")
	@Before("execution(* com.sl.revision.demo.aop.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint jp) {
		//System.out.println(jp.getSignature());
		String arg = jp.getArgs()[0].toString();
		System.out.println("Before Loggers with Argument: " + arg);
	}
	
	//@After("execution(* *.*.checkout())")
	@After("execution(* com.sl.revision.demo.aop.ShoppingCart.checkout(..))")
	public void afterLogger() {
		System.out.println("After Logger");
	}
	
	
	@Pointcut("execution(* com.sl.revision.demo.aop.ShoppingCart.quantity(..))")
	public void afterReturningPointCut() {
		
	}
	
	@AfterReturning(pointcut = "afterReturningPointCut()",
			returning = "retVal")
	public void afterReturning(int retVal) {
		System.out.println("After Returning : " + retVal);
	}
	
}
