package com.lsy.platform.mqconsumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@Slf4j
public class MQConsumerApplicationTest {
    @Resource
    RocketMQTemplate  rocketMQTemplate;
    /**
     * 批量消息
     */
    @Test
    void asyncSendBatch() {
        Message<String> msg = MessageBuilder.withPayload("hello world test1").build();
        List<Message> msgList = Arrays.asList(msg,msg,msg,msg,msg);
        SendResult res = rocketMQTemplate.syncSend("example", msgList);
        log.info("批量消息");
    }
}
