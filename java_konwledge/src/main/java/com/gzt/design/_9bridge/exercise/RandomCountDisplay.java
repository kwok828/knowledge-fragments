package com.gzt.design._9bridge.exercise;

import com.gzt.design._9bridge.CountDisplay;
import com.gzt.design._9bridge.DisplayImpl;

import java.util.Random;


public class RandomCountDisplay extends CountDisplay {
    private final Random random = new Random();
    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDisplay(int maxRandomTimes) {
        super.multiDisplay(random.nextInt(maxRandomTimes));
    }
}
