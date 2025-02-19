package com.gzt.design._7bulider;

public class Director {
    private Bulider bulider;
    public Director(Bulider bulider) {
        this.bulider = bulider;
    }
    public void construct() {
        bulider.makeTitle("Greeting");
        bulider.makeString("从早上至下午");
        bulider.makeItems(new String[] { "早上好。", "下午好。" });
        bulider.makeString("晚上");
        bulider.makeItems(new String[] { "晚上好。", "晚安。", "再见。" });
        bulider.close();
    }
}
