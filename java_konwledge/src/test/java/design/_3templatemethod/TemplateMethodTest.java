package design._3templatemethod;

import com.gzt.design._3templatemethod.AbstractDisplay;
import com.gzt.design._3templatemethod.CharDisplay;
import com.gzt.design._3templatemethod.StringDisplay;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TemplateMethodTest {

    /**
     * 1. AbstractClass(抽象类)
     * AbstractClass角色不仅负责声明在模板方法中所使用到的抽象方法，还负责规定抽象方法在 执行方法 中的执行顺序。
     * 这些抽象方法由子类 ConcreteClass角色负责实现。在示例程序中，由AbstractDisplay 类扮演此角色
     *
     * 2. ConcreteClass(具体类)
     * 该角色负责具体实现 AbstractClass角色中定义的抽象方法。这里实现的方法将会在 AbstractClass
     * 角色的模板方法中被调用。在示例程序中，由CharDisplay类和 stringDisplay类扮演此角色。
     */
    @Test
    public void test() {
        AbstractDisplay displayChar = new CharDisplay('H');
        displayChar.display();
        System.out.println();
        System.out.println("********************************");
        AbstractDisplay displayStr = new StringDisplay("Hello World. ");
        displayStr.display();
    }
}
