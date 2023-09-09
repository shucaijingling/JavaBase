package com.shucai.concurrent.atomicfieldupdate;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicFieldUpdate {


    static class Alex {

        volatile int salary;

        public int getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {

        AtomicIntegerFieldUpdater<Alex> updater = AtomicIntegerFieldUpdater.newUpdater(Alex.class, "salary");

        Alex alex = new Alex();
        updater.addAndGet(alex, 10);

        updater.compareAndSet(alex, 10, 1);
        System.out.println(alex.getSalary());
        assert updater.compareAndSet(alex, 10, 2);

    }
}
