package com.shucai.concurrent.atomicreference;

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
import java.util.concurrent.atomic.AtomicReference;

/**
 * 测试synchronized 和 AtomicReference
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 20)
@Measurement(iterations = 20)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class AtomicReference4 {

    @State(Scope.Group)
    public static class MonitorRace {
        private DebitCard debitCard = new DebitCard("Alex", 0);

        private void syncInc() {
            synchronized (AtomicReference4.class) {
                final DebitCard dc = debitCard;
                DebitCard newDC = new DebitCard(dc.getAccount(), dc.getAmount() + 10);
                this.debitCard = newDC;
            }
        }
    }

    @State(Scope.Group)
    public static class AtomicReferenceRace {
        private AtomicReference<DebitCard> ref = new AtomicReference<>(new DebitCard("Alex", 0));

        public void casInc() {
            DebitCard dc = ref.get();
            DebitCard newDC = new DebitCard(dc.getAccount(), dc.getAmount() + 10);
            ref.compareAndSet(dc, newDC);
        }
    }

    @GroupThreads(10)
    @Group("sync")
    @Benchmark
    public void syncInc(MonitorRace monitorRace) {
        monitorRace.syncInc();
    }

    @Benchmark
    @Group("atomic")
    @GroupThreads(10)
    public void casInc(AtomicReferenceRace referenceRace) {
        referenceRace.casInc();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(AtomicReference4.class.getSimpleName())
                .forks(1)
                .timeout(TimeValue.seconds(10))
                .addProfiler(StackProfiler.class)
                .build();

        new Runner(options).run();
    }

}
