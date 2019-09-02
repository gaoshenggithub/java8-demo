package cn.andy;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Optional;

public class OptionalApi {

    @Test
    public void test1() {
        //of 方法中如果传入的参数是null, 会抛出空指针异常
        //Optional<Object> o = Optional.of(null);
        Optional<Object> optional = Optional.ofNullable(null);
        Object object = optional.orElse("abc");//如果内部为空,返回abc
        System.out.println("object = " + object);
    }

    @Test
    public void test2() {
        String str = "java";
        String repeat = str.repeat(4);
        System.out.println("repeat = " + repeat);
    }

    @Test
    public void test3() throws Exception {
        FileInputStream stream = new FileInputStream("D:\\OpenSources\\IntelliJIDEA\\Leyou\\java8-demo\\java11demo\\src\\main\\java\\cn\\andy\\ApiTest.java");
        byte[] buffer = new byte[stream.available()];
        stream.read(buffer);
        stream.close();
        String s = new String(buffer);
        s.lines().forEach(System.out::println);
    }
}
