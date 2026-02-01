package com.epam.contest.taskTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeadlockTask {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        Thread writerThread = new Thread(() -> {
            while (true) {
                synchronized (numbers) {
                    int num = random.nextInt(100) + 1;
                    numbers.add(num);
                    System.out.println("Added: " + num);
                }
                try { Thread.sleep(500); } catch (InterruptedException e) { break; }
            }
        });

        Thread sumThread = new Thread(() -> {
            while (true) {
                synchronized (numbers) {
                    int sum = numbers.stream().mapToInt(Integer::intValue).sum();
                    System.out.println("Current Sum: " + sum);
                }
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        });

        Thread sqrtThread = new Thread(() -> {
            while (true) {
                synchronized (numbers) {
                    double sumOfSquares = numbers.stream()
                            .mapToDouble(n -> Math.pow(n, 2))
                            .sum();
                    System.out.println("Sqrt of Sum of Squares: " + Math.sqrt(sumOfSquares));
                }
                try { Thread.sleep(1500); } catch (InterruptedException e) { break; }
            }
        });

        writerThread.start();
        sumThread.start();
        sqrtThread.start();
    }
}