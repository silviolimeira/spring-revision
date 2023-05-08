package com.sl.revision.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

	@Pointcut("within(com.sl.revision..*)")
	public void authenticationgPointCut() {
		        
		
	}
	
	@Pointcut("within(com.sl.revision..*)")
	public void authorizationPointCut() {
		
	}
	
	@Before("authenticationgPointCut() && authorizationPointCut()")
	public void authenticate() {
		System.out.println("Authenticating the Request");
	}
}
