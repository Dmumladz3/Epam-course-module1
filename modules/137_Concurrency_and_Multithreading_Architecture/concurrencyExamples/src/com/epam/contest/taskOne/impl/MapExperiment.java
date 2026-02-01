package com.epam.contest.taskOne.impl;

import java.util.*;

public class MapExperiment {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Initialize with HashMap to observe ConcurrentModificationException
        Map<Integer, Integer> map = new HashMap<>();

        // To fix, uncomment one of these:
        // Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
        // Map<Integer, Integer> map = new ConcurrentHashMap<>();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
                try { Thread.sleep(1); } catch (InterruptedException e) { break; }
            }
        });

        Thread reader = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    long sum = 0;
                    // Iterating over map.values() throws CME if map is HashMap
                    for (Integer value : map.values()) {
                        sum += value;
                    }
                    System.out.println("Sum: " + sum);
                }
            } catch (ConcurrentModificationException e) {
                System.err.println("FAILED: ConcurrentModificationException caught!");
            }
        });

        reader.start();
        writer.start();
        writer.join();
        reader.interrupt();
    }
}