package com.shucai.concurrent.atomicinteger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 10)
@Warmup(iterations = 10)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SynchronizedVsLockVsAtomicInteger {

    @State(Scope.Group)
    public static class IntMonitor {
        private int x;

        private final Lock lock = new ReentrantLock();

        //lock进行共享资源同步
        public void lockInc() {
            lock.lock();
            try {
                x++;
            } finally {
                lock.unlock();
            }
        }

        //Synchronized同步共享资源
        public void syncInc() {
            synchronized (this) {
                x++;
            }
        }
    }

    @State(Scope.Group)
    public static class atomicIntegerMonitor {
        private AtomicInteger x = new AtomicInteger();

        public void inc() {
            x.incrementAndGet();
        }
    }

    @Benchmark
    @GroupThreads(10)
    @Group("sync")
    public void syncInc(IntMonitor monitor) {
        monitor.syncInc();
    }

    @Benchmark
    @GroupThreads(10)
    @Group("lock")
    public void lockInc(IntMonitor monitor) {
        monitor.lockInc();
    }

    @Benchmark
    @GroupThreads(10)
    @Group("atomic")
    public void inc(atomicIntegerMonitor monitor) {
        monitor.inc();
    }

    public static void main(String[] args) throws RunnerException {
        final Options op = new OptionsBuilder()
                .include(SynchronizedVsLockVsAtomicInteger.class.getSimpleName())
                .forks(1)
                .timeout(TimeValue.seconds(10))
                .addProfiler(StackProfiler.class)
                .build();

        new Runner(op).run();
    }
}
