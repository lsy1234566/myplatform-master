package com.lsy.study.benchmark;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.ByteBuffer;
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
@Fork(1)
@Threads(2)
public class BufferTest {

    //直接分配系统内存
    @Benchmark
    public ByteBuffer directAllocate() {
        ByteBuffer byteBuffer = null;
        for (int i = 0; i < 20; i++) {
            byteBuffer = ByteBuffer.allocateDirect(1024);
        }
        return byteBuffer;
    }

    //JVM堆分配内存
    @Benchmark
    public ByteBuffer allocate() {
        ByteBuffer allocate = null;
        for (int i = 0; i < 20; i++) {
            allocate = ByteBuffer.allocate(1024);
        }
        return allocate;
    }

    //直接内存-操作-连续二十次添加
    @Benchmark
    public ByteBuffer useDirectAllocate() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byte[] bytes = "a".getBytes();
        for (int i = 0; i < 20; i++) {
            byteBuffer.put(bytes);
        }
        return byteBuffer;
    }

    //JVM堆内内存-操作-连续二十次添加
    @Benchmark
    public ByteBuffer useAllocate() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = "a".getBytes();
        for (int i = 0; i < 20; i++) {
            byteBuffer.put(bytes);
        }
        return byteBuffer;
    }

    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(BufferTest.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opts).run();

    }


    @Test
    public void directAllocateTest(){
        long start = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        }
        long end = System.nanoTime();
        System.out.println("执行时间:"+(end-start));
        //执行时间:317900
        //执行时间:297100
        //执行时间:295000
        //执行时间:282100
    }

    //JVM堆分配内存
    @Test
    public void allocateTest(){
        long start = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            ByteBuffer allocate = ByteBuffer.allocate(1024);
        }
        long end = System.nanoTime();
        System.out.println("执行时间:"+(end-start));
        //执行时间:34100
        //执行时间:36400
        //执行时间:37700
        //执行时间:31700
    }

    //直接内存-操作-连续二十次添加
    @Test
    public void  useDirectAllocateTest() {
        long start = System.nanoTime();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byte[] bytes = "a".getBytes();
        for (int i = 0; i < 1000; i++) {
            byteBuffer.put(bytes);
        }
        long end = System.nanoTime();
        System.out.println("执行时间:"+(end-start));
        //执行时间:444900
        //执行时间:510900
        //执行时间:338800
        //执行时间:339700
    }

    //JVM堆内内存-操作-连续二十次添加
    @Test
    public void  useAllocateTest() {
        long start = System.nanoTime();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = "a".getBytes();
        for (int i = 0; i < 1000; i++) {
            byteBuffer.put(bytes);
        }
        long end = System.nanoTime();
        System.out.println("执行时间:"+(end-start));
        //执行时间:92700
        //执行时间:93300
        //执行时间:78700
    }


}

