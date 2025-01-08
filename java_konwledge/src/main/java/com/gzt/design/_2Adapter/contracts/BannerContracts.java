package com.gzt.design._2Adapter.contracts;

public class BannerContracts {
    private String string;
    public BannerContracts(String string) {
        this.string = string;
    }

    public void showWithPare(){
        System.out.println("(" + string + ")");
    }

    public void showWithAster(){
        System.out.println("*" + string + "*");
    }

}
