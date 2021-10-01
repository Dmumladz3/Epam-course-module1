package com.epam.contest.lessonTwo.forkJoinPool;

import java.util.concurrent.ForkJoinPool;

import static com.epam.contest.lessonTwo.forkJoinPool.FibonacciTask.fibLoop;
import static com.epam.contest.lessonTwo.forkJoinPool.FibonacciTask.fibRecur;


public class FibonacciTaskExample {

    public static void main(String[] args) {
        assert new ForkJoinPool().invoke(new FibonacciTask(10)) == 55L;
        assert fibRecur(10) == 55L;
        assert fibLoop(10) == 55L;
    }
}