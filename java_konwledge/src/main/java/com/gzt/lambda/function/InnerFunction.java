package com.gzt.lambda.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InnerFunction {
    public void consumerFunction(Consumer<String> c, String param) {
        c.accept(param);
    }

    public void supplierFunction(Supplier<String> s) {
        String string = s.get();
        System.out.println(string);
    }

    public void functionFunction(Function<Integer, String> f, Integer param) {
        String res = f.apply(param);
        System.out.println("double param is: " + res);
    }

    public void predicateFunction(Predicate<Integer> p, Integer param) {
        boolean res = p.test(param);
        System.out.println("boolean param is: " + res);
    }
}
