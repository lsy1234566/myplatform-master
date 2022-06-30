package com.lsy.study.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 基准测试
 */
@BenchmarkMode(Mode.AverageTime)
//Throughput： 整体吞吐量，比如QPS，单位时间内的调用量等。
//AverageTime： 平均耗时，指的是每次执行的平均时间。如果这个值很小不好辨认，可以把统计的单位时间调小一点。
//SampleTime： 随机取样。
//SingleShotTime： 如果你想要测试仅仅一次的性能，比如第一次初始化花了多长时间，就可以使用这个参数，其实和传统的main方法没有什么区别。
//All： 所有的指标，都算一遍，你可以设置成这个参数看下效果。
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
//timeUnit：时间的单位，默认的单位是秒。
//iterations：预热阶段的迭代数。
//time：每次预热的时间。
//batchSize：批处理大小，指定了每次操作调用几次方法。
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 2)
@Threads(2)
public class StreamForEachTest {

    ArrayList<Integer> arrayList = new ArrayList<>(10000000);

    @Setup  // @Setup 会在执行 benchmark 之前被执行，正如其名，主要用于初始化。
    public void prepare() {
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void streamForEach() {
        arrayList.stream().forEach(num -> num++);
    }

    @Benchmark
    public void forEach() {
        for (Integer integer : arrayList) {
            integer++;
        }
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(StreamForEachTest.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opts).run();
    }
}

