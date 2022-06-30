package com.lsy.study.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 基准测试
 */
@BenchmarkMode(Mode.AverageTime)
//Mode
//Mode 表示 JMH 进行 Benchmark 时所使用的模式。通常是测量的维度不同，或是测量的方式不同。目前 JMH 共有四种模式：
//
//Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
//AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
//SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
//SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
//timeUnit：时间的单位，默认的单位是秒。
//iterations：预热阶段的迭代数。
//time：每次预热的时间。
//batchSize：批处理大小，指定了每次操作调用几次方法。
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//进行 fork 的次数。如果 fork 数是2的话，则 JMH 会 fork 出两个进程来进行测试。
@Fork(1)
//@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 2)
@Threads(2)
public class BenchmarkTest {

   /*http://deepoove.com/jmh-visual-chart/ 可视化界面*/

    @Setup  // @Setup 会在执行 benchmark 之前被执行，正如其名，主要用于初始化。
    public void prepare() {
    }

    @TearDown // @TearDown 和 @Setup 相对的，会在所有 benchmark 执行结束以后执行，主要用于资源的回收等。
    public void shutdown() {
    }

    //直接分配系统内存
    @Benchmark
    public void t10() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //JVM堆分配内存
    @Benchmark
    public void t100() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //直接内存-操作-连续二十次添加
    @Benchmark
    public void t1000() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opts).run();
        //Benchmark                               Mode  Samples        Score  Score error  Units
        //c.i.c.c.t.MyBenchmark.testObjectKey    thrpt        3  1976766.072   408421.217  ops/s
        //c.i.c.c.t.MyBenchmark.testStringKey    thrpt        3   423788.869   222139.136  ops/s

        //Benchmark列表示这次测试对比的方法，Mode列表上结果的统计纬度，Samples列表示采样次数，
        // Samples=Fork*Iteration。Score是对这次评测的打分，对于testObjectKey，意味着他的OPS为每秒1976766，大约4倍testStringKey方法
        //Score Error 这里表示性能统计上的误差，我们不需要关心这个数据，主要查看Score
        //可以修改统计纬度，比如修改为Mode.SampleTime，时间按照纳秒统计
    }
}

