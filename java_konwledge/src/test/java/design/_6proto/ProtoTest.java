package design._6proto;

import com.gzt.design._6proto.Manager;
import com.gzt.design._6proto.MessageBox;
import com.gzt.design._6proto.Product;
import com.gzt.design._6proto.UnderlinePen;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProtoTest {
    @Test
    public void testProto() {
        /**
         * 1. Prototype(原型)
         * 用于定义复制现有实例来生成新实例的接口。
         * 2. ConcretePrototype(具体的原型)
         * 实现复制现有实例并生成新实例的方法
         * 3. Client(使用者)
         * 使用复制实例的方法生成新的实例
         *
         * 使用 clone 方法可以快速创建一个对象的副本，避免了通过构造函数重新初始化对象的开销，尤其是在对象包含大量数据或复杂结构时。
         * clone 方法可以实现深拷贝（deep copy）或浅拷贝（shallow copy），根据具体需求选择不同的克隆策略。默认是浅拷贝
         */
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox warningBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');
        manager.register("strong message", underlinePen);
        manager.register("warning box", warningBox);
        manager.register("slash box", slashBox);
        Product strongMessage = manager.create("strong message");
        strongMessage.use("strong message");
        Product warningBox1 = manager.create("warning box");
        warningBox1.use("warning box");
        Product slashBox1 = manager.create("slash box");
        slashBox1.use("slash box");
    }
}
