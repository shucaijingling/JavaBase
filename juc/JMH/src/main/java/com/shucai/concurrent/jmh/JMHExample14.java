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
import org.openjdk.jmh.infra.Blackhole;
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
public class JMHExample14 {

    double x1 = PI;
    double x2 = PI * 2;
    @Benchmark
    public double test1() {
        return Math.pow(x1, 2);
    }

    @Benchmark
    public double measureLog1() {
        Math.log(PI);
        return Math.pow(x2, 2);
    }

    @Benchmark
    public double measureLog2() {

        return Math.pow(x1, 2) + Math.pow(x2, 2);
    }

    @Benchmark
    public void useBlackHole(Blackhole hole) {
        hole.consume(Math.pow(x1, 2));
        hole.consume(Math.pow(x2, 2));
    }

    @Benchmark
    public double measureLog3() {
       return Math.log(PI);
    }

    public static void main(String[] args) throws RunnerException {

        final Options options = new OptionsBuilder()
                .include(JMHExample14.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

}
