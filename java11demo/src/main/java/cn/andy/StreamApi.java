package cn.andy;

import org.junit.Test;

import java.util.stream.Stream;

public class StreamApi {

    @Test
    public void test1() {
        Stream<Integer> stream = Stream.of(3, 4, 5, 6, 7, 8);
        stream.forEach(System.out::println);
        System.out.println("************************");
        //创建一个空对象
        Stream<Object> stream1 = Stream.of();
        stream1.forEach(System.out::println);

        System.out.println("************************");

        //会被解析成一个数组对象,进而访问他的长度
        // Stream<Object> stream2 = Stream.of(null);
        //stream2.forEach(System.out::println);

        //可以创建一个null来创建流对象
        Stream<Object> stream3 = Stream.ofNullable(null);
        stream3.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream<Integer> stream = Stream.of(3, 9, 5, 6, 7, 2, 234, 11, 32);
        Stream<Integer> stream1 = stream.takeWhile(e -> e % 2 != 0);
        stream1.forEachOrdered(System.out::println);

        System.out.println("********************");

        Stream<Integer> stream2 = Stream.of(20, 1, 1, 1, 1, 1);
        Stream<Integer> stream3 = stream2.dropWhile(e -> e % 2 == 0);
        stream3.forEachOrdered(System.out::println);
    }

    @Test
    public void test3() {
        //流的迭代 创建流
        Stream<Integer> stream = Stream.iterate(1, e -> (2 * e) + 1);
        stream.limit(10).forEach(System.out::println);

        //有限的迭代
        Stream<Integer> stream1 = Stream.iterate(1, e -> e < 1000, e -> (2 * e) + 1);
        stream1.forEach(System.out::println);
    }

    @Test
    public void test4() {

    }
}
