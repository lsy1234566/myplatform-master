package com.lsy.platform.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

//    @Bean
//    @LoadBalanced  // 使用Ribbon作为负载均衡
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}

