package com.gzt.design._9bridge.exercise2;

import com.gzt.design._9bridge.CountDisplay;
import com.gzt.design._9bridge.DisplayImpl;

public class IncreaseDisplay extends CountDisplay {
    // 步长
    private int step;

    /**
     * @param impl 具体实现类
     * @param step 步长，打印主体的次数
     */
    public IncreaseDisplay(DisplayImpl impl, int step) {
        super(impl);
        this.step = step;
    }

    public void increaseDisplay(int times) {
        // count 从0开始，每次加step，表示下次主体需要打印的次数
        int count = 0;
        // times 次数，表示总共需要打印的次数
        for (int i = 0; i < times; i++) {
            multiDisplay(count);
            count += step;
        }
    }
}
