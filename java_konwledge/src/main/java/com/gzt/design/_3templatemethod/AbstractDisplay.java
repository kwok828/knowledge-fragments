package com.gzt.design._3templatemethod;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    // 模板方法由父类决定抽象方法的执行顺序，所以display方法禁止子类重写，那么就需要使用final修饰
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
