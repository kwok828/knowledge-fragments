package design._2adapter;

import com.gzt.design._2adapter.exercise.FileIO;
import com.gzt.design._2adapter.exercise.FileProperties;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootTest
public class ExerciseTest {

    @Test
    public void test() {
        FileIO fileIO = new FileProperties();
        try {
            // 获取项目根目录路径
            String projectPath = System.getProperty("user.dir");
            // 构建源文件和目标文件的路径
            String originFile = Paths.get(projectPath, "src", "test", "java", "design", "_2Adapter", "test.txt").toString();
            String destFile = Paths.get(projectPath, "src", "test", "java", "design", "_2Adapter", "testNew.txt").toString();
            fileIO.readFromFile(originFile);
            fileIO.setValue("month", "1");
            fileIO.setValue("day", "9");
            fileIO.writeToFile(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
