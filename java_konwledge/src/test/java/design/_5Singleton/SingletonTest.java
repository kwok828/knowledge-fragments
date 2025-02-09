package design._5Singleton;

import com.gzt.design._5singleton.InnerLazyLoadSingleton;
import com.gzt.design._5singleton.LazyLoadSingleton;
import com.gzt.design._5singleton.PreloadSingleton;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonTest {
    @Test
    public void testSingleton() {
        // 预加载
        PreloadSingleton preloadSingleton = PreloadSingleton.getInstance();
        PreloadSingleton preloadSingleton2 = PreloadSingleton.getInstance();
        System.out.println(preloadSingleton == preloadSingleton2);

        // 双重检查锁
        LazyLoadSingleton lazyLoadSingleton = LazyLoadSingleton.getInstance();
        LazyLoadSingleton lazyLoadSingleton2 = LazyLoadSingleton.getInstance();
        System.out.println(lazyLoadSingleton == lazyLoadSingleton2);

        // 私有静态内部类
        InnerLazyLoadSingleton innerLazyLoadSingleton = InnerLazyLoadSingleton.getInstance();
        InnerLazyLoadSingleton innerLazyLoadSingleton2 = InnerLazyLoadSingleton.getInstance();
        System.out.println(innerLazyLoadSingleton == innerLazyLoadSingleton2);
    }
}
