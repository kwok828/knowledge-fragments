package design._10strategy;

import com.gzt.design._10strategy.Hand;
import com.gzt.design._10strategy.Player;
import com.gzt.design._10strategy.ProbStrategy;
import com.gzt.design._10strategy.WinningStrategy;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrategyTest {
    /**
     * 1.Strategy(策略)
     * Strategy角色负责决定实现策略所必需的接口(API)。
     * 2.ConcreteStrategy(具体的策略)
     * ConcreteStrategy角色负责实现Strategy角色的接口(API)，即负责实现具体的策略(战略、方向、方法和算法)。
     * 3.Context(上下文)
     * 负责使用Strategy角色。Context角色保存了ConcreteStrategy角色的实例，并使用ConcreteStrategy角色去实现需求(总之，还是要调用Strategy角色的接口(API))。
     */
    @Test
    public void test() {
        Player player1 = new Player("Taro", new WinningStrategy(314));
        Player player2 = new Player("Hana", new ProbStrategy(15));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
               player1.even();
               player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
