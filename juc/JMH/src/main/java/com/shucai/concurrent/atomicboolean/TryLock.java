package com.shucai.concurrent.atomicboolean;

import java.util.concurrent.atomic.AtomicBoolean;

public class TryLock {

    private final AtomicBoolean ab = new AtomicBoolean(false);

    private final ThreadLocal<Boolean> threadLocal = ThreadLocal.withInitial(() -> false);

    public boolean tryLock() {
        boolean result = ab.compareAndSet(false, true);

        if (result) {
            threadLocal.set(true);
        }
        return result;
    }

    public boolean release() {
        if (threadLocal.get()) {
            threadLocal.set(false);
            return ab.compareAndSet(true, false);
        }else {
            return false;
        }
    }
}
