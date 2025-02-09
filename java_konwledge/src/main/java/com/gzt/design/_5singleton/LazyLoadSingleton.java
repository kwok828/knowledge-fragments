package com.gzt.design._5singleton;

// 懒加载，双重检查锁  因为并发情况下可能同时进入if，需要锁机制保证只有一个线程执行实例初始化
public class LazyLoadSingleton {
    private static LazyLoadSingleton instance;
    private LazyLoadSingleton() {}
    public static synchronized LazyLoadSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyLoadSingleton.class) {
                if (instance == null) {
                    instance = new LazyLoadSingleton();
                }
            }
        }
        return instance;
    }
}
