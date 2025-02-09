package com.gzt.design._5singleton;

public class PreloadSingleton {
    // 预加载    jvm初始化即加载
    private static PreloadSingleton instance = new PreloadSingleton();
    private PreloadSingleton() {}
    public static PreloadSingleton getInstance() {
        return instance;
    }
}
