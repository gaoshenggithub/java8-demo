package com.lambda.stream;

import lombok.var;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一. Stream的三个操作步骤:
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStreamAPI2 {
	List<Dept> list = new ArrayList<Dept>() {{
		add(new Dept("张三", "123456", 23l));
		add(new Dept("李四", "abcdef", 54l));
		add(new Dept("王五", "asfaf", 65l));
		add(new Dept("王五", "数据层", 99l));
		add(new Dept("王五", "Test", 33l));
		add(new Dept("王五", "Test", 33l));
		add(new Dept("王五", "Test", 33l));
		add(new Dept("王五", "Test", 33l));
	}};

	/**
	 * 筛选和切片
	 * filter -- 接收Lambda,从流中排除某些元素
	 * limit -- 段截流,使其元素不超过给定数量.
	 * skip -- 跳过元素,返回一个扔掉前n个元素的流,若流中元素不足n个,则返回一个空流,与limit(n) 互补
	 * distinct -- 通过流所生成元素hashCode() 和 equals 去除重复元素
	 */

	/**
	 * 筛选
	 */
	@Test
	public void test1() {

		//中间操作不会执行任何操作
		Stream<Dept> stream = list.stream().filter(
				(e) -> {
					System.out.println(".....");
					return e.getAge() > 50;
				});
		//终止操作: 一次性执行全部内容,即 "惰性求值"
		stream.forEach(System.out::println);
	}

	/**
	 * 截断流
	 */
	@Test
	public void test2() {
		list.stream().filter((e) -> {
			System.out.println("!!!");
			return e.getAge() > 40;
		}).limit(2).forEach(System.out::println);
	}

	/**
	 * 跳过元素
	 */
	@Test
	public void test3() {
		list.stream().filter((e) -> {
			System.out.println("@@@");
			return e.getAge() > 30;
		}).skip(2).forEach(System.out::println);
	}

	/**
	 * 去重
	 */
	@Test
	public void test4() {
		list.stream().filter((e) -> {
			System.out.println("!!!!!");
			return e.getAge() > 1;
		}).distinct().forEach(System.out::println);
	}

	/**
	 * 映射
	 * map -- 接受Lambda,将元素转换为其他形式或提取信息.
	 *       接收一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素.
	 * flatMap -- 接受一个作为参数,
	 * 将流中的每个值都换成另一个流然后把所有流连成一个流
	 */
	/**
	 * Map映射
	 */
	@Test
	public void test5() {
		List<String> l = new ArrayList<String>() {{
			add("aaaa");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		l.stream().map((e) -> e.toUpperCase()).forEach(System.out::println);
		System.out.println("--------------------------");

		list.stream().map(Dept::getAge).forEach(System.out::println);
	}

	@Test
	public void test6() {
		List<String> l = new ArrayList<String>() {{
			add("aaaa");
			add("cccc");
			add("dddd");
			add("eeee");
		}};

		l.stream().map(
				TestStreamAPI2::filterCharacter).forEach(e -> e.forEach(System.out::println));

	}

	@Test
	public void test7() {
		List<String> l = new ArrayList<String>() {{
			add("aaaa");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		var buffer = new StringBuffer();
		l.stream().flatMap(TestStreamAPI2::filterCharacter).forEach(
				e->{
					var e1 = e.toString();
					buffer.append(e1);
				}
				);
		System.out.println(buffer);
		System.out.println("l = " + l);
	}

	public static Stream<Character> filterCharacter(String str) {
		return new ArrayList<Character>() {{
			for (Character c : str.toCharArray()) {
				add(c);
			}
		}}.stream();
	}

	/**
	 * 排序
	 * sorted() -- 自然排序(Comparable)
	 * sorted() -- 定制排序(Comparator)
	 */
	@Test
	public void test8() {
		List<String> l = new ArrayList<String>() {{
			add("aaaa");
			add("cccc");
			add("dddd");
			add("1111");
		}};
		l.stream().sorted().forEach(System.out::println);

		System.out.println("-----------------------------------");

		list.stream().sorted((e1,e2)->{
			if (e1.getAge().equals(e2.getAge())){
				return e1.getUsername().compareTo(e2.getUsername());
			}else{
				return -e1.getAge().compareTo(e2.getAge());
			}
		}).forEach(System.out::println);
	}
}
