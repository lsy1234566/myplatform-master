package com.lsy.study.benchmark;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@Measurement(iterations = 2, time = -1, timeUnit = TimeUnit.SECONDS, batchSize = 4000)
public class AccessibleTest {

    public static int publicAcc() {
        return 1;
    }

    private static int privateAcc() {
        return 1;
    }

    protected static int protectedAcc() {
        return 1;
    }

    static int defaultcAcc() {
        return 1;
    }

    @Benchmark
    public int publicAcct() {
        return publicAcc();
    }
    @Benchmark
    public int privateAcct() {
        return privateAcc();
    }
    @Benchmark
    public int protectedAcct() {
        return protectedAcc();
    }
    @Benchmark
    public int defaultcAcct() {
        return defaultcAcc();
    }


    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(AccessibleTest.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opts).run();
    }


}

