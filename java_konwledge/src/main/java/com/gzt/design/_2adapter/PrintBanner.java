package com.gzt.design._2adapter;

public class PrintBanner extends Banner implements Print{
    private String string;

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithPare();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
