package com.gzt.design._3templatemethod;

public class StringDisplay extends AbstractDisplay{
    private String str;
    public StringDisplay(String str) {
        this.str = str;
    }
    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(str);
    }

    @Override
    public void close() {
        System.out.print(">>");
    }
}
