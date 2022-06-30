//package com.lsy.platform.mqconsumer.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.ConsumeMode;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@RocketMQMessageListener(consumerGroup = "example-group", topic = "example",consumeMode = ConsumeMode.ORDERLY)
//public class RocketMQ implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String str) {
//        log.info("===>"+str);
//    }
//
//
//}
