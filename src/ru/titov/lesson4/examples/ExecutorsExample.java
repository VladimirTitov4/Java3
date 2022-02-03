package ru.titov.lesson4.examples;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newWorkStealingPool();

        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
                System.out.printf("Hello, %s!\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//
//
        for (int i = 0; i < 5; i++) {
            int finalI = i; // эта переменная используется, чтобы имитировать финальную переменную.
            Callable<Double> callable = () -> {
                System.out.printf("Hello, %s!\n", Thread.currentThread().getName());
                Thread.sleep(500);
                return Math.pow(2, finalI);
            };
            Future<Double> future = executorService.submit(callable);
            System.out.println("future.get() = "  + future.get());
        }


//        Thread.sleep(100);

//        for (int i = 0; i < 5; i++) {
//            executorService.submit(task);
//        }
////
//        Thread.sleep(100);

        executorService.shutdown();
//        executorService.shutdownNow();
    }


}
