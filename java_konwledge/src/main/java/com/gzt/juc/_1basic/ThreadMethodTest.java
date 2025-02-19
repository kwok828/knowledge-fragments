package com.gzt.juc._1basic;

import java.util.concurrent.TimeUnit;

/**
 * @Author: gzt
 * @Description:
 * @Date: 2025-02-19
 */
public class ThreadMethodTest {
    /**
     * 线程状态：
     * 操作系统层面：
     *【初始状态】仅是在语言层面创建了线程对象，还未与操作系统线程关联
     *【可运行状态】与操作系统线程关联，但尚未执行，此时线程处于就绪状态，等待CPU调度
     *【运行状态】指获取了 CPU 时间片运行中的状态，时间片结束后，转换为【可运行状态】，此处产生上下文切换
     *【阻塞状态】调用了阻塞 API，线程实际不会使用CPU，进入【阻塞状态】，产生上下文切换。
     *          阻塞操作完成后，线程会从【阻塞状态】变为【可运行状态】
     *         【阻塞状态】的线程只要一直不唤醒，调度器就不会考虑它
     *【终止状态】表示线程已经执行完毕，生命周期已经结束，不会再转换为其它状态
     *
     * JavaAPI层面:
     * NEW  线程刚被创建，但是还没有调用start() 方法
     * RUNNABLE 当调用了start() 方法之后
     * BLOCKED、WAITING、TIMED_WAITING 对【阻塞状态】的细分
     * TERMINATED 当线程代码运行结束
     */
    public static void main(String[] args) {
        startWithRun();
        sleepWithYield();
    }

    /**
     * lambda方式创建线程
     * 直接调用 run 是在主线程中执行了 run，没有启动新的线程
     * 使用 start 是启动新的线程，通过新的线程间接执行 run 中的代码
     */
    private static void startWithRun() {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        }, "thread1");
        t.start();
        System.out.println("call run");
        t.run();
    }

    /**
     * sleep
     * 1. 调用 sleep 会让当前线程从 Running  进入 Timed Waiting 状态（阻塞）
     * 2. 其它线程可以使用  interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException
     * 3. 睡眠结束后的线程未必会立刻得到执行
     * 4. 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性  TimeUnit.SECONDS.sleep(1);
     *
     * yield
     * InterruptedException
     * 1. 调用 yield 会让当前线程从 Running 进入 Runnable  就绪状态，然后调度执行其它线程
     * 2. 具体的实现依赖于操作系统的任务调度器
     */
    private static void sleepWithYield() {
        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                //TimeUnit.SECONDS.sleep(1);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long end = System.currentTimeMillis();
            System.out.println("t1 start... cost" + (end - start));
        }, "t1").start();
        Thread t2 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println("------>1 " + count++);
            }
        }, "t2");
        Thread t3 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                /**
                 * 线程优先级会提示（hint）调度器优先调度该线程，但它!仅仅是一个提示!，调度器可以忽略它
                 * 如果 cpu 比较忙，那么优先级高的线程会获得更多的时间片，但 cpu 闲时，优先级几乎没作用
                 */
                Thread.yield();
                System.out.println("------>2 " + count++);
            }
        }, "t3");
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t3.start();
    }

}
