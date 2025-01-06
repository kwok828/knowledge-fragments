package com.gzt.lambda.function;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FunctionTest {

    // 只包含一个抽象方法的接口 + @FunctionalInterface注解，称为函数式接口。
    @Test
    public void testFunction() {
        // 作为参数传递 Lambda 表达式：为了将 Lambda 表达式作为参数传递，
        // 接收Lambda表达式的参数类型必须是与该 Lambda 表达式兼容的函数式接口的类型。
        AnimalFunction func = new AnimalFunction();
        // 此处 lambda 实现了函数式接口，执行了具体逻，调用animalAction后实际调用animal接口的action，该action被lambda实现，所以实际执行lambda
        func.animalAction((animalName) -> System.out.println(animalName + " gnaw bone"), "dog");
        func.animalAction((animalName) -> System.out.println(animalName + " eat fish"), "cat");
    }

    //Java 内置四大核心函数式接口
    /**  函数式接口                     参数类型         返回类型                            用途
     * Consumer<T>消费型接口              T              void          对类型为T的对象应用操作，包含方法：void accept(T t)
     * Supplier<T>供给型接口             无                T          返回类型为T的对象，包含方法：T get()
     * Function<T, R>函数型接口           T                R         对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：R apply(T t)
     * Predicate<T>断定型接口             T            boolean      确定类型为T的对象是否满足某约束，并返回boolean 值。包含方法：boolean test(T t)
     */
    @Test
    public void testConsumerFunction() {
        InnerFunction innerFunction = new InnerFunction();
        innerFunction.consumerFunction(param -> System.out.println("参数为："+param), "test");
        System.out.println("*****************************************");
        innerFunction.supplierFunction(() -> "test");
        System.out.println("*****************************************");
        innerFunction.functionFunction(param -> String.valueOf(param * 2), 10);
        System.out.println("*****************************************");
        innerFunction.predicateFunction(bool -> bool == 1, 1);
    }
}
