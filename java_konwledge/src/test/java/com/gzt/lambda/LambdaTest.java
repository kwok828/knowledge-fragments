package com.gzt.lambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.TreeMap;

@SpringBootTest
public class LambdaTest {

    @Test
    public void testLambdaBase() {
        // 原始声明线程类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-Hello World");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setName("origin");
        thread.start();

        System.out.println("*******************************");

        // lambda
        // 语法格式一：无参，无返回值       （） -> {}   左边参数  右边逻辑  单语句时可以省略{}
        // 语法格式二：有参，无返回值       （String str） -> {...}   左边参数  右边逻辑  单语句时可以省略{}
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()+"-Hello World"));
        thread2.setName("lambda");
        thread2.start();
    }

    @Test
    public void testLambdaBase2() {
        // 定制compare
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // o1 < o2   -> -1
                // o1 == o2   -> 0
                // o1 > o2   -> 1
                int compare = Integer.compare(o1.length(), o2.length());
                // 长度相同比较大小
                if (compare == 0){
                    return o1.compareTo(o2);
                }
                return compare;
            }
        });
        treeMap.put("world", "hello");
        treeMap.put("hello", "world");
        treeMap.put("abcde", "fghij");
        System.out.println(treeMap);

        System.out.println("*******************************");

        // 语法格式三：有参，有返回值       （o1, o2） -> {...; return ...;}   左边参数，支持类型推断，即无需显式声明参数类型  右边逻辑,最后返回结果
        TreeMap<String, String> treeMap2 = new TreeMap<>((o1, o2) -> {
            int compare = Integer.compare(o1.length(), o2.length());
            if (compare == 0){
                return o1.compareTo(o2);
            }
            return compare;
        });
        treeMap2.put("world", "hello");
        treeMap2.put("hello", "world");
        treeMap2.put("abcde", "fghij");
        System.out.println(treeMap2);
    }

}
