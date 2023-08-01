package com.shucai.concurrent.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Threads(5)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class JMHExample10 {

    @Param({"1", "2", "3", "4"})
    private int type;

    private Map<Long, Long> map;

    @Setup
    public void setUp() {
        switch (type) {
            case 1:
                this.map = new ConcurrentHashMap<>();
                break;
            case 2:
                this.map = new ConcurrentSkipListMap<>();
                break;
            case 3:
                this.map = new Hashtable<>();
                break;
            case 4:
                this.map = Collections.synchronizedMap(new HashMap<>());
                break;
            default:
                throw new IllegalArgumentException("Illegal map type");
        }
    }

    @Benchmark
    public void test() {
        this.map.put(System.nanoTime(), System.nanoTime());
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JMHExample10.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
