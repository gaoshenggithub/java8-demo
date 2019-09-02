package com.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Lambda表达式
 */
public class LamBdaDemo {

	/**
	 * 无参数无返回值
	 */
	@Test
	public void test1() {
		Runnable rb = new Runnable() {
			int i = 0;

			@Override
			public void run() {
				System.out.println("\"\" = " + "运行中.....");
			}
		};
		rb.run();

		System.out.println("\"================\" = " + "================");

		Runnable run = () -> {
			System.out.println("\"运行中///////////\" = " + "运行中///////////");
		};
		run.run();
	}

	/**
	 * 有参无返回值
	 */
	@Test
	public void test2() {
		Consumer<String> consumer = (str) -> System.out.println("str = " + str);
		consumer.accept("23123213");
	}

	/**
	 * 有参有返回值
	 */
	@Test
	public void test3() {
		Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
		int compare = comparator.compare(14, 12);
		System.out.println("compare = " + compare);

		Comparator<Long> l = (x, y) -> Long.compare(x, y);
		int compare1 = l.compare(14l, 11l);
		System.out.println("compare1 = " + compare1);
	}

	@Test
	public void test4() {
		Long sum = sum(123l, (x) -> x * x);
		System.out.println("sum = " + sum);
		String s = new String("........");
		Function<String, Object> runnable = String::new;

	}

	public Long sum(Long l1, MyNumber myNumber) {
		return myNumber.getValue(l1);
	}
}
