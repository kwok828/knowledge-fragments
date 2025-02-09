package design._4factorymethod;

import com.gzt.design._4factorymethod.framework.Factory;
import com.gzt.design._4factorymethod.framework.Product;
import com.gzt.design._4factorymethod.idcard.IDCardFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FactoryMethodTest {
    /**
     * 1. Product(产品)
     * Product角色属于框架这一方，是一个抽象类。它定义了在Factory Method 模式中生成的那些实例所持有的接口(API)，
     * 但具体的处理则由子类ConcreteProduct角色决定。在示例程序中，由Product 类扮演此角色。
     * 2. ConcreteProduct(具体的产品)
     * ConcreteProduct角色属于具体加工这一方，它决定了具体的产品。在示例程序中，由IDCard类扮演此角色。
     * 3. Creator(创建者)
     * Creator角色属于框架这一方，它是负责生成Product角色的抽象类，但具体的处理则由子类ConcreteCreator角色决定。在示例程序中，由Factory类扮演此角色。
     * 不用new关键字来生成实例，而是调用生成实例的专用方法来生成实例，这样就可以防止父类与其他具体类耦合。
     * 4. ConcreteCreator(具体的创建者)
     * ConcreteCreator角色属于具体加工这一方，它负责生成具体的产品。在示例程序中，由IDCardFactory类扮演此角色。
     */
    @Test
    public void testFactoryMethod() {
        Factory factory = new IDCardFactory();
        Product zs = factory.create("zs");
        Product ls = factory.create("ls");
        Product ww = factory.create("ww");
        zs.use();
        ls.use();
        ww.use();
    }
}
