package design._7Bulider;

import com.gzt.design._7bulider.Director;
import com.gzt.design._7bulider.HTMLBulider;
import com.gzt.design._7bulider.TextBulider;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class BuliderTest {

    /**
     * 1.Builder(建造者)
     * Builder角色负责定义用于生成实例的接口(API)。Builder角色中准备了用于生成实例的方法。
     * 在示例程序中，由Builder类扮演此角色。
     * 2.ConcreteBuilder(具体的建造者)
     * ConcreteBuilder角色是负责实现 Builder角色的接口的类(API)。这里定义了在生成实例时实际被调用的方法。
     * 此外，在ConcreteBuilder角色中还定义了获取最终生成结果的方法。在示例程序中，由TextBuilder类和HTMLBuilder类扮演此角色。
     * 3.Director(监工)
     * Director 角色负责使用 Builder角色的接口(API)来生成实例。它并不依赖于ConcreteBuilder角色。
     * 为了确保不论 ConcreteBuilder角色是如何被定义的，Director角色都能正常工作，它只调用在Builder角色中被定义的方法。
     * 在示例程序中，由Director类扮演此角色。
     */

    @Test
    public void test() {
        TextBulider textBulider = new TextBulider();
        Director director = new Director(textBulider);
        director.construct();
        String result = textBulider.getResult();
        System.out.println(result);
    }

    @Test
    public void test2() {
        HTMLBulider htmlBulider = new HTMLBulider();
        Director director = new Director(htmlBulider);
        director.construct();
        String result = htmlBulider.getResult();
        System.out.println(result);
        // 删除文件
        /*File file = new File(result);
        file.delete();*/
    }
}
