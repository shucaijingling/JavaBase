package com.shucai.concurrent.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * OutputTimeUnit 统计时间单位
 */

@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Threads(5)
public class JMHExample07 {


    @Benchmark
    public void test(Test test) throws InterruptedException {
        test.method();
    }

    @State(Scope.Benchmark)
    public static class Test {
        public Test() {
            System.out.println("create instance");
        }

        public void method() {

        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder().include(JMHExample07.class.getSimpleName())
                .build();
        new Runner(opts).run();
    }
}
