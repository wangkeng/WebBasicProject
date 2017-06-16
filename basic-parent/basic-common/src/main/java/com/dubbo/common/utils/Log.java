package com.dubbo.common.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	

	private Logger logger = Logger.getLogger(getClass());

	// 可以尝试下这两种注解
	// @Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		String clazzName = thisJoinPoint.getTarget().getClass().getName();
		String methodName = thisJoinPoint.getSignature().getName();
		Object[] args = thisJoinPoint.getArgs();
		// 计时并调用目标函数
		long start = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		long time = System.currentTimeMillis() - start;

		// 输出计时信息
		logger.info("-------------------操作计时：" + time + "ms  类名: " + clazzName + "  方法名:"
				+ methodName + "()-----------------------------"+Arrays.toString(args));

		return result;
	}
}
