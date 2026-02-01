package com.epam.contest.taskOne.impl;

import java.util.HashMap;
import java.util.Map;

public class SynchronizedThreadSafeMap<K, V> {
    private final Map<K, V> internalMap = new HashMap<>();

    public synchronized void put(K key, V value) {
        internalMap.put(key, value);
    }

    public synchronized V get(K key) {
        return internalMap.get(key);
    }

    public synchronized int size() {
        return internalMap.size();
    }
}