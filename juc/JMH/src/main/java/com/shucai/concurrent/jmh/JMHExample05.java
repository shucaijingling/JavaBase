package com.shucai.concurrent.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
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
 * OutputTimeUnit 统计时间单位
 */

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
public class JMHExample05 {


    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }


    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder().include(JMHExample05.class.getSimpleName())
                .timeUnit(TimeUnit.NANOSECONDS)
                .forks(1)
                .build();
        new Runner(opts).run();
    }
}
