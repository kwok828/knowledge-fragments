package com.gzt.lambda.function;

@FunctionalInterface
public interface Animal<T> {
    public void action(T animalName);
}
