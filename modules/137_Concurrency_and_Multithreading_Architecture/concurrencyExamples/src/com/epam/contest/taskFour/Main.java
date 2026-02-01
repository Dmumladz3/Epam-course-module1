package com.epam.contest.taskFour;

public class Main {
    public static void main(String[] args) {
        BlockingObjectPool pool = new BlockingObjectPool(3); // Pool size 3

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Object obj = pool.get();
                    System.out.println("Thread 1 GOT object: " + obj);
                    Thread.sleep(100);
                    pool.take(obj);
                    System.out.println("Thread 1 RETURNED object");
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Object obj = pool.get();
                    System.out.println("Thread 2 GOT object: " + obj);
                    Thread.sleep(200);
                    pool.take(obj);
                    System.out.println("Thread 2 RETURNED object");
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
    }
}