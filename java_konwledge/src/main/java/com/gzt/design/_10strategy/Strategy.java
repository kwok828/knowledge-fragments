package com.gzt.design._10strategy;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
