package com.gzt.design._4factorymethod.idcard;

import com.gzt.design._4factorymethod.framework.Product;

public class IDCard extends Product {
    private String owner;
    // 禁止非idcard包外的类new，强制使用工厂生成实例
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }
    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡。");
    }
    public String getOwner() {
        return owner;
    }
}
