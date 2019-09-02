package cn.andy;

import org.junit.Test;

import java.io.FileOutputStream;
import java.net.URL;

public class InputStreamTest {

    @Test
    public void test1() throws Exception {
        var loader = this.getClass().getClassLoader();
        var is = loader.getResourceAsStream("D:\\OpenSources\\IntelliJIDEA\\Leyou\\java8-demo\\java11demo\\src\\main\\resources\\file");
        try (var file = new FileOutputStream("D:\\OpenSources\\IntelliJIDEA\\Leyou\\java8-demo\\java11demo\\src\\main\\resources\\file3")) {
            is.transferTo(file);
        } catch (Exception e) {

        } finally {
            is.close();
        }
    }
}
