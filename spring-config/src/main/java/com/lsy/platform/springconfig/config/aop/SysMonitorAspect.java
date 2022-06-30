package com.lsy.platform.springconfig.config.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class SysMonitorAspect {
    SysMonitorAspect() {
    }

    @Pointcut("@annotation(SysMonitor)")
    private void getSysMonitorAspectPointCut() {
    }

    @Around("getSysMonitorAspectPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = joinPoint.proceed();
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return proceed;
    }

}
