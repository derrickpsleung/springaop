package com.example.springaop.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Pointcut("execution(* com.example.springaop.services..*(..))")
	public void execute() {
	}

	@Around("execute()")
	public String aroundExecute(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("aroundExecute " + pp.getThis());

		if (httpServletRequest.getParameter("isMock") != null) {
			System.out.println("is mock");
			return "mocked";
		} else {
			return (String) pp.proceed();
		}
	}

//	@Before("initialization(* com.example.springaop.services.*.*(..))")
//	public String beforeInit() {
//		System.out.println("beforeInit");
//		return "abc";
//	}

}
