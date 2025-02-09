package com.gzt.design._6proto;

public class MessageBox extends ConcreteProduct{
    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length+4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
        System.out.println(decoChar + " " + s + " " + decoChar);
        for (int i = 0; i < length+4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
    }

    // 与UnderlinePen同样的实现，直接添加父类来实现这个方法，继承父类使用
    /*@Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }*/
}
