package com.gzt.design._4factorymethod.framework;

public abstract class Factory {
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
}
