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

import static java.lang.Math.log;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class JMHExample15 {

    // x1和x2是使用final修饰的常量
    private final double x1 = 124.456;
    private final double x2 = 342.456;

    // y1和y2则是普通的成员变量
    private double y1 = 124.456;
    private double y2 = 342.456;

    // 直接返回124.456×342.456的计算结果，主要用它来作基准
    @Benchmark
    public double returnDirect()
    {
        return 42_620.703936d;
    }

    // 两个常量相乘，我们需要验证在编译器的早期优化阶段是否直接计算出了x1乘以x2的值
    @Benchmark
    public double returnCaculate_1()
    {
        return x1 * x2;
    }

    // 较为复杂的计算，计算两个未被final修饰的变量，主要也是用它来作为对比的基准
    @Benchmark
    public double returnCaculate_2()
    {
        return log(y1) * log(y2);
    }

    // 较为复杂的计算，操作的同样是final修饰的常量，查看是否在编译器优化阶段进行了常量的折叠行为
    @Benchmark
    public double returnCaculate_3()
    {
        return log(x1) * log(x2);
    }

    public static void main(String[] args) throws RunnerException
    {
        final Options opts = new OptionsBuilder()
                .include(JMHExample15.class.getSimpleName())
                .build();
        new Runner(opts).run();
    }

}
