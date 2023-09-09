package com.shucai.concurrent.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
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

import static java.lang.Math.PI;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JMHExample13 {

    @Benchmark
    public void test1() {

    }

    @Benchmark
    public void measureLog1() {
        Math.log(PI);
    }

    @Benchmark
    public void measureLog2() {
        double log = Math.log(PI);
        Math.log(log);
    }

    @Benchmark
    public double measureLog3() {
       return Math.log(PI);
    }

    public static void main(String[] args) throws RunnerException {

        final Options options = new OptionsBuilder()
                .include(JMHExample13.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

}
