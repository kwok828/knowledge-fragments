package design._8abstractfactory;

import com.gzt.design._8abstractfactory.factory.Factory;
import com.gzt.design._8abstractfactory.factory.Link;
import com.gzt.design._8abstractfactory.factory.Page;
import com.gzt.design._8abstractfactory.factory.Tray;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class AbstarctFactoryTest {
    /**
     * 1.AbstractProduct(抽象产品)
     * AbstractProduct角色负责定义AbstractFactory角色所生成的抽象零件和产品的接口(API)。在示例程序中，由Link类、Tray类和Page类扮演此角色
     * 2.AbstractFactory(抽象工厂)
     * AbstractFactory角色负责定义用于生成抽象产品的接口(API)。在示例程序中，由Factory类扮演此角色。
     * 3.Client(委托者)
     * Client角色仅会调用 AbstractFactory角色和 AbstractProduct角色的接口(API)来进行工作，对于具体的零件、产品和工厂一无所知。
     * 4.ConcreteProduct(具体产品)
     * ConcreteProduct角色负责实现 AbstractProduct角色的接口(API)。
     * 5.ConcreteFactory(具体工厂)
     * ConcreteFactory角色负责实现 AbstractFactory角色的接口(API)。
     */
    @Test
    public void test() {
        Factory factory = Factory.getFactory("com.gzt.design._8abstractfactory.listfactory.ListFactory");
        Link yahoo = factory.createLink("YAHOO", "http://www.yahoo.com");
        Link msn = factory.createLink("MSN", "http://www.msn.com");
        Link bing = factory.createLink("BING", "http://www.bing.com");
        Link google = factory.createLink("GOOGLE", "http://www.google.com");
        Tray trayNews = factory.createTray("日报");
        trayNews.add(yahoo);
        Tray traySearch = factory.createTray("检索引擎");
        traySearch.add(google);
        traySearch.add(msn);
        traySearch.add(bing);
        Page page = factory.createPage("首页", "GZT");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
        System.out.println("------------------------------------------------------");
        /*File file = new File("首页.html");
        file.delete();*/
    }
}
