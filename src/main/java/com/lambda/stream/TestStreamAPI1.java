package com.lambda.stream;

import com.lambda.functionimple.Andy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 一. Stream 的三个操作步骤
 *
 * 1. 创建Stream
 * 2. 中间件
 * 3. 终止操作
 */
public class TestStreamAPI1 {

	//创建Stream
	@Test
	public void test1(){
		//1.可以通过Collection 系列 集合提供的stream() 或paraelStream()
		ArrayList<Object> list = new ArrayList<>();

		Stream<Object> stream = list.stream();

		//2.通过Arrays中的静态方法stream() 获取数组流
		Andy[] andies = new Andy[10];
		Stream<Andy> stream1 = Arrays.stream(andies);

		//3.通过Stream类中的静态方法
		Stream<String> stream5 = Stream.of("aasdfsf", "b1sdfb", "cc123");

		//4.创建无限流
		Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
		iterate.limit(10).forEach(System.out::println);
	}
}
