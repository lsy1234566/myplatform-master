//package com.lsy.platform.business.config;
//
//import org.apache.catalina.startup.Tomcat;
//import org.apache.coyote.UpgradeProtocol;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.web.ServerProperties;
//import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
///**
// * @Description: \
// * @author: 林思源
// * @date: 2022.03.20
// */
//@Configuration(
//        proxyBeanMethods = false
//)
//@ConditionalOnClass({Tomcat.class, UpgradeProtocol.class})
//public class TomcatConfig {
//
//    public TomcatConfig() {
//    }
//
//    @Bean
//    public TomcatWebServerFactoryCustomizer tomcatWebServerFactoryCustomizer(Environment environment, ServerProperties serverProperties) {
//        return new TomcatWebServerFactoryCustomizer(environment, serverProperties);
//    }
//
//}