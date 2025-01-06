package com.gzt.lambda.function;

public class AnimalFunction {
    public void animalAction(Animal<String> animal, String animalName) {
        animal.action(animalName);
    }
}
