package com.gzt.design._2adapter;

public class Banner {
    private String string;
    public Banner(String string) {
        this.string = string;
    }

    public void showWithPare(){
        System.out.println("(" + string + ")");
    }

    public void showWithAster(){
        System.out.println("*" + string + "*");
    }

}
