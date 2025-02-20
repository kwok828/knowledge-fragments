package design._9bridge;

import com.gzt.design._9bridge.CountDisplay;
import com.gzt.design._9bridge.Display;
import com.gzt.design._9bridge.StringDisplayImpl;
import com.gzt.design._9bridge.exercise.RandomCountDisplay;
import com.gzt.design._9bridge.exercise2.CharDisplayImpl;
import com.gzt.design._9bridge.exercise2.IncreaseDisplay;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BridgeTest {

    /**
     * 1.Abstraction(抽象化)-Display
     * 该角色位于“类的功能层次结构”的最上层。它使用Implementor角色的方法定义了基本的功能。该角色中保存了Implementor角色的实例。
     * 2.RefinedAbstraction(改善后的抽象化)-CountDisplay
     * 在 Abstraction角色的基础上增加了新功能的角色。
     * 3.Implementor(实现者)-DisplayImpl
     * 该角色位于“类的实现层次结构”的最上层。它定义了用于实现Abstraction角色的接口(API)的方法。
     * 4.Concretelmplementor(具体实现者)-StringDisplayImpl
     * 该角色负责实现在 Implementor角色中定义的接口(API)
     */
    @Test
    public void test() {
        Display d1 = new Display(new StringDisplayImpl("Hello, world."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, world with today."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.multiDisplay(5);
    }

    @Test
    public void testRandomDisplay() {
        RandomCountDisplay d3 = new RandomCountDisplay(new StringDisplayImpl("Hello, Universe Random Display."));
        d3.randomDisplay(10);
    }

    @Test
    public void testIncreaseDisplay() {
        IncreaseDisplay d4 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        IncreaseDisplay d5 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        d4.increaseDisplay(4);
        d5.increaseDisplay(6);
    }
}
