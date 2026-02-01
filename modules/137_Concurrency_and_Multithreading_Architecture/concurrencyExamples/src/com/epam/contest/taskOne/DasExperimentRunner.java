package com.epam.contest.taskOne;

import com.epam.contest.taskOne.impl.LockBasedThreadSafeMap;
import com.epam.contest.taskOne.impl.SynchronizedThreadSafeMap;

import java.util.*;
import java.util.concurrent.*;

public class DasExperimentRunner {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("PHASE 1: OBSERVING THE PROBLEM");
        runCrashExperiment();

        System.out.println("PHASE 2: PERFORMANCE BENCHMARK");
        int ops = 100_000;

        runBenchmark("Collections.synchronizedMap", () -> {
            Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
            performWork(map, ops);
        });

        runBenchmark("ConcurrentHashMap", () -> {
            Map<Integer, Integer> map = new ConcurrentHashMap<>();
            performWork(map, ops);
        });

        runBenchmark("Custom Synchronized Map", () -> {
            SynchronizedThreadSafeMap<Integer, Integer> map = new SynchronizedThreadSafeMap<>();
            for (int i = 0; i < ops; i++) {
                map.put(i, i);
                map.get(i);
            }
        });

        runBenchmark("Custom Lock-Based Map", () -> {
            LockBasedThreadSafeMap<Integer, Integer> map = new LockBasedThreadSafeMap<>();
            for (int i = 0; i < ops; i++) {
                map.put(i, i);
                map.get(i);
            }
        });
    }

    private static void runCrashExperiment() throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
            }
        });

        Thread reader = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    for (Integer v : map.values()) {
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Result: HashMap threw ConcurrentModificationException as expected.");
            }
        });

        reader.start();
        writer.start();

        writer.join();
        reader.interrupt();
        reader.join();
    }

    private static void performWork(Map<Integer, Integer> map, int ops) {
        for (int i = 0; i < ops; i++) {
            map.put(i, i);
            map.get(i);
        }
    }

    private static void runBenchmark(String label, Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        System.out.println(label + ": " + (end - start) + "ms");
    }
}