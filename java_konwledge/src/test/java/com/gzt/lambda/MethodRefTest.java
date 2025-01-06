package com.gzt.lambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class MethodRefTest {
    /**
     * 使用操作符“::” 将类(或对象) 与方法名分隔开来。
     *  对象::实例方法名
     *  类::静态方法名
     *  类::实例方法名
     */
    @Test
    public void testMethodRef() {
        HashMap<String, String> map = new HashMap<>();
        map.put("c1", "d");
        map.put("aa1", "d");
        map.put("a1", "b");
        map.put("b1", "c");
        map.forEach(System.out::printf);
        System.out.println();
        System.out.println("******************************");
        map.forEach(this::sout);
    }

    public void sout(String k, String v){
        System.out.println(k + "-" + v);
    }
}
