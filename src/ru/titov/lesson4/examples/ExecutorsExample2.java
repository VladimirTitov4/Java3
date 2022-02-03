package ru.titov.lesson4.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
                System.out.printf("Hello, %s!\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            executorService.execute(runnable);
        }

        executorService.shutdown();
    }
}
