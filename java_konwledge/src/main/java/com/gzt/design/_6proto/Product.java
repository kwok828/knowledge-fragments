package com.gzt.design._6proto;

public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
