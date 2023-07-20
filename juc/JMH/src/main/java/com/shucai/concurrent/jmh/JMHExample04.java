package com.shucai.concurrent.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 必须标注@benchMark 否则会报错
 */

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
public class JMHExample04 {

    /**
     * 平均值
     */
    @BenchmarkMode(Mode.AverageTime)
    @Benchmark
    public void testAverageTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * 吞吐量
     */
    @BenchmarkMode(Mode.Throughput)
    @Benchmark
    public void testThroughput() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * 时间采样
     */
    @BenchmarkMode(Mode.SampleTime)
    @Benchmark
    public void testTSimpleTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * SingleShotTime
     * @throws InterruptedException
     */
    @BenchmarkMode(Mode.SingleShotTime)
    @Benchmark
    public void testSingleShotTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * 多统计模式
     * @throws InterruptedException
     */
    @BenchmarkMode({Mode.SingleShotTime,Mode.AverageTime})
    @Benchmark
    public void testMulti() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * all
     * @throws InterruptedException
     */
    @BenchmarkMode(Mode.All)
    @Benchmark
    public void testAll() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }


    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder().include(JMHExample04.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opts).run();
    }
}
