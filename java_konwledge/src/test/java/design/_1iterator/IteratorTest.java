package design._1iterator;

import com.gzt.design._1iterator.Book;
import com.gzt.design._1iterator.BookShelf;
import com.gzt.design._1iterator.Iterator;
import com.gzt.design._1iterator.exercise.BookShelfList;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IteratorTest {

    /**
     * 将书放置到书架上
     * 实现步骤：
     * 1. 创建一个展示集合的接口         Aggregate -> 创建迭代器实现遍历
     * 2. 创建一个迭代器接口用于遍历     方法1：是否存在下一个元素   方法2：获取下一个元素
     * 3. 创建书类                    展示书名
     * 4. 创建书架迭代器的实现类        实现具体逻辑
     * 5. 创建一个书架                规定书架大小，上书，获取书，获取书架实际大小，生成书架迭代器
     */
    @Test
    public void testArray() {
        // 创建书架
        BookShelf bookShelf = new BookShelf(4);
        // 上书
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        // 遍历书架
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }

    // 将数组存储替换为集合存储
    @Test
    public void testArrayList() {
        // 创建书架
        BookShelfList bookShelfList = new BookShelfList(4);
        // 上书
        bookShelfList.addBook(new Book("Around the World in 80 Days"));
        bookShelfList.addBook(new Book("Bible"));
        bookShelfList.addBook(new Book("Cinderella"));
        bookShelfList.addBook(new Book("Daddy-Long-Legs"));
        // 遍历书架
        Iterator iterator = bookShelfList.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
