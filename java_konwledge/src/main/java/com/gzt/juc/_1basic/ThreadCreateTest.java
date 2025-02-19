package com.gzt.juc._1basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: gzt
 * @Description:
 * @Date: 2025-02-19
 */
public class ThreadCreateTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        soutWithThread();
        soutWithRunnable();
        soutWithFutureTask();

    }

    private static void soutWithThread() {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        }, "thread1");
        t.start();
    }

    /**
     * 实现Runnable接口的方式创建线程
     */
    private static void soutWithRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        };
        new Thread(runnable, "thread2").start();
    }

    /**
     * FutureTask方式创建线程
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void soutWithFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("hello3");
            return "hello futureTask";
        });
        new Thread(futureTask, "thread3").start();
        System.out.println(futureTask.get());
    }
}
