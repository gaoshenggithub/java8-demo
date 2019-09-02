package cn.andy;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ApiTest {
    public static void main(String[] args) {
        var a = 10;
        System.out.println("a = " + a);
    }

    @Test
    public void test1() {
        var list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
    }

    @Test
    public void test2() {
        //集合的创建可以使用更加简单的方式
        var list = List.of(1, 2, 3, 4, 5, 6, 7);
        // list.add(3);//UnsupportedOperationException 不支持添加元素
        list.forEach(System.out::println);
    }

    /**
     * 集合中增强的API
     */
    @Test
    public void test3() {
        LocalDate of = LocalDate.of(2017, 11, 1);
        System.out.println("of = " + of);
        //添加重复元素会抛出异常
        //Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //set.forEach(System.out::println);

        Stream<Integer> stream = Stream.of(491, 1, 1, 1, 3);
    }


}
