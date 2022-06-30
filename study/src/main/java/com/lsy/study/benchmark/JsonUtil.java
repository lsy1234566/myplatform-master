package com.lsy.study.benchmark;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.study.json.JsonTest;
import com.lsy.study.json.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 基准测试
 */
@BenchmarkMode(Mode.Throughput)//基准测试类型
@OutputTimeUnit(TimeUnit.MILLISECONDS)//基准测试结果的时间类型
@Warmup(iterations = 3)//预热的迭代次数
@Threads(2)//测试线程数量
@State(Scope.Thread)//该状态为每个线程独享
//度量:iterations进行测试的轮次，time每轮进行的时长，timeUnit时长单位,batchSize批次数量
@Measurement(iterations = 2, time = -1, timeUnit = TimeUnit.SECONDS, batchSize = -1)
public class JsonUtil {
    String jsonString = "{\"id\":11,\n" +
            "  \"name\":\"钟无艳\",\n" +
            "        \"birthDay\":\"2021-06-01T12:23:00.235+08:00\",\n" +
            "        \"feature\":[],\n" +
            "        \"idCard\":\"35092312316514\"" +
            "}";
    User user =new User(1,"lsy1",new Date(),new LinkedList(),"3511895812121x");

    @Benchmark
    public User fastJsonDeSerialize() {
        //FastJson解析
        User user1 = null;
        for (int i = 0; i < 1000; i++) {
            user1 = JSON.parseObject(jsonString, User.class);
        }
        return user1;
    }

    @Benchmark
    public User jacksonDeSerialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user=null;
        for (int i = 0; i < 1000; i++) {
            user = objectMapper.readValue(jsonString, User.class);
        }
        return user;

    }

    @Benchmark
    public String fastJsonSerialize() {
        //FastJson解析'
        String userStr = null;
        for (int i = 0; i < 1000; i++) {
            userStr = JSON.toJSONString(user);
        }
        return userStr;
    }

    @Benchmark
    public String jacksonSerialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userStr = null;
        for (int i = 0; i < 1000; i++) {
            userStr = objectMapper.writeValueAsString(user);
        }
        return userStr;

    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(JsonUtil.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opts).run();
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class User {
        private int id;
        private String name;
        private Date birthDay;
        private List feature;
        private transient String idCard;
    }



    @Test
    public void fastJsonDeSerialize1() throws IOException {
        //FastJson解析
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            User user1 = JSON.parseObject(jsonString, User.class);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        long l3 = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        for (int i = 0; i < 1000; i++) {
            User user = objectMapper.readValue(jsonString, User.class);
        }
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3);
    }

    @Test
    public void fastJsonSerialize1() throws JsonProcessingException {
        //FastJson 1000：245 100000：369
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String userStr = JSON.toJSONString(user);
        }
        long l2 = System.currentTimeMillis();

        //jackson 1000：61 100000：333
        System.out.println(l2-l1);
        ObjectMapper objectMapper = new ObjectMapper();
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String userStr1 = objectMapper.writeValueAsString(user);
        }
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3);
    }

}

