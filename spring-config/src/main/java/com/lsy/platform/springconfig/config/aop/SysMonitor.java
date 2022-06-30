package com.lsy.platform.springconfig.config.aop;


import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SysMonitor {
}

