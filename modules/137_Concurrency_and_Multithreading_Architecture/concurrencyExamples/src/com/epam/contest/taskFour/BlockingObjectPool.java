package com.epam.contest.taskFour;

import java.util.LinkedList;
import java.util.Queue;


public class BlockingObjectPool {

    private final Queue<Object> pool;
    private final int size;

    public BlockingObjectPool(int size) {
        this.size = size;
        this.pool = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            pool.add(new Object());
        }
    }

    public synchronized Object get() {
        while (pool.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Object item = pool.poll();
        notifyAll();
        return item;
    }


    public synchronized void take(Object object) {
        while (pool.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        pool.add(object);
        notifyAll();
    }
}