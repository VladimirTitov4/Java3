package ru.titov.lesson4.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newWorkStealingPool();

        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName()); // выводим имя потока
            lock.wait(2000); // ждем 2000 мс
            System.out.println("Finished"); // выводим что закончили
            return "result";
        };

        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }

        Thread.sleep(100);

        executorService.shutdown();
    }
}
