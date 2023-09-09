package com.shucai.concurrent.atomicreference.generated;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
public class AtomicReference4_AtomicReferenceRace_jmhType_B2 extends AtomicReference4_AtomicReferenceRace_jmhType_B1 {
    public volatile int setupTrialMutex;
    public volatile int tearTrialMutex;
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> setupTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "setupTrialMutex");
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> tearTrialMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "tearTrialMutex");

    public volatile int setupIterationMutex;
    public volatile int tearIterationMutex;
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> setupIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "setupIterationMutex");
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> tearIterationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "tearIterationMutex");

    public volatile int setupInvocationMutex;
    public volatile int tearInvocationMutex;
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> setupInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "setupInvocationMutex");
    public final static AtomicIntegerFieldUpdater<AtomicReference4_AtomicReferenceRace_jmhType_B2> tearInvocationMutexUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicReference4_AtomicReferenceRace_jmhType_B2.class, "tearInvocationMutex");

    public volatile boolean readyTrial;
    public volatile boolean readyIteration;
    public volatile boolean readyInvocation;
}
