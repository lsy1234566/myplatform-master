package com.lsy.platform.business;


import com.lsy.platform.business.controller.TAActivityController;
import com.lsy.platform.business.service.ITAActivityService;
import com.lsy.platform.business.service.impl.TAActivityServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.lsy.platform.business","com.lsy.platform.springconfig"})
@MapperScan("com.lsy.platform.business.mapper")
@EnableDiscoveryClient
@EnableTransactionManagement
public class BusinessApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BusinessApplication.class, args);
        ITAActivityService tAActivityController = run.getBean("tAActivityServiceImpl", ITAActivityService.class);
        tAActivityController.getActivityInfo(1);
    }
}

