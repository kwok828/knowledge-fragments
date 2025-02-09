package design._2adapter;

import com.gzt.design._2adapter.Print;
import com.gzt.design._2adapter.PrintBanner;
import com.gzt.design._2adapter.contracts.PrintBannerContracts;
import com.gzt.design._2adapter.contracts.PrintContracts;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdapterTest {
    /**
     * 将输人的字符串显示为(Hello)或是*He1lo*
     * 1. Print接口决定打印方式，弱化输出/强化输出
     * 2. Banner类是具体的输出内容
     * 3. PrintBanner类继承Banner类实现Print接口,实际的逻辑由PrintBanner执行，调用Banner中的方法执行打印
     */
    /**
     * 1. Target(对象) 该角色负责定义所需的方法。由Print接口(使用继承时)和Print类(使用委托时)扮演此角色。
     * 2. Client(请求者) 该角色负责使用Target角色所定义的方法进行具体处理。
     * 3. Adaptee(被适配) Adaptee是一个持有既定方法的角色。
     * // 如果 Adaptee 角色中的方法与Target角色的方法相同(也就是说家庭使用的电压就是 12伏特直流电压)，就不需要接下来的 Adapter 角色了,
     * 4. Adapter(适配) Adapter模式的主人公。
     */
    @Test
    public void test() {
        // 使用继承的方式
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }

    @Test
    public void test2() {
        // 使用委托的方式
        PrintContracts printContracts = new PrintBannerContracts("Hello");
        printContracts.printWeak();
        printContracts.printStrong();
    }
    // 为什么上述要使用多态而不直接使用PrintBanner/PrintBannerContracts声明？
    /**
     * PrintBanner类和Print接口对外提供的方法是相同的。但是在有些情况下，PrintBanner类中的方法可能会比Print接口中的方法多。
     * 通过将对象保存在Print类型的变量中并使用该变量，可以明确地表明程序的意图，即“并不是使用 PrintBanner 类中的方法，而是使用 Print 接口中的方法”
     */

}
