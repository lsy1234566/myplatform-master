package com.lsy.platform.mqconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(scanBasePackages = {"com.lsy.platform.mqconsumer","com.lsy.platform.springconfig"})
@SpringBootApplication(scanBasePackages = {"com.lsy.platform.mqconsumer"})
//@MapperScan("com.lsy.platform.business.mapper")
//@EnableDiscoveryClient
//@EnableFeignClients
public class MQConsumerApplication {
    public static void main(String[] args) {
         SpringApplication.run(MQConsumerApplication.class, args);
    }
}
