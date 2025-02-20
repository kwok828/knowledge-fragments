package com.gzt.design._10strategy;

public class Hand {
    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    private static final String[] name = {"石头", "剪刀", "布"};
    // 猜拳时所出的手势值
    private int handvalue;
    public Hand(int handvalueGuu) {
        this.handvalue = handvalueGuu;
    }
    //根据手势值返回对应的手势实例
    public static Hand getHand(int handvalue) {
        return hand[handvalue];
    }
    // 判断当前手势是否大于对方手势
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }
    // 判断当前手势是否小于对方手势
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

}
