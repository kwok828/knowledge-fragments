package com.gzt.design._5singleton;

// 私有静态内部类 相较于双重检查锁 可以实现无锁保证线程安全，代码更加简洁
public class InnerLazyLoadSingleton {
    private InnerLazyLoadSingleton() {}
    private static class SingletonHolder {
        private static final InnerLazyLoadSingleton INSTANCE = new InnerLazyLoadSingleton();
    }
    public static InnerLazyLoadSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
