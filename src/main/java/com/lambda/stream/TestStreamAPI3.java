package com.lambda.stream;

import lombok.var;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {
	List<EmpLoyee> empLoyees = new ArrayList<EmpLoyee>() {{
		add(new EmpLoyee("张三", 1222.33, 56l, EmpLoyee.Status.BUSY));
		add(new EmpLoyee("张三", 1222.33, 56l, EmpLoyee.Status.BUSY));
		add(new EmpLoyee("张三", 1222.33, 56l, EmpLoyee.Status.BUSY));
		add(new EmpLoyee("张三", 1222.33, 56l, EmpLoyee.Status.BUSY));
		add(new EmpLoyee("李四", 14342.33, 11l, EmpLoyee.Status.FREE));
		add(new EmpLoyee("王五", 1218.33, 99l, EmpLoyee.Status.VOCATION));
		add(new EmpLoyee("李六", 1299.33, 300l, EmpLoyee.Status.BUSY));
		add(new EmpLoyee("田七", 120.33, 340l, EmpLoyee.Status.VOCATION));
	}};


	/**
	 * 收集
	 * collect- 将流转换为其他形式, 接收一个Collector接口的实现
	 * 用于给Stream中元素做汇总的方法
	 */


	/**
	 * 使用map--reduce计算数量
	 */

	@Test
	public void test12(){
		Optional<Long> reduce = empLoyees.stream().map(e -> 1l).reduce(Long::sum);
		System.out.println("reduce = " + reduce.get());
	}

	/**
	 * 1.给定一个数字列表, 如何返回一个由每个数平方构成的列表呢?
	 * 列如:
	 */

	@Test
	public void test11() {
		Long[] l = {1l, 2l, 3l, 4l, 5l, 6l, 7l};

		Arrays.stream(l).map(e -> e * e).forEach(System.out::println);
	}


	//拼接分割
	@Test
	public void test10() {
		String collect = empLoyees.stream().map(EmpLoyee::getUsername).distinct().collect(Collectors.joining(","));
		System.out.println("collect = " + collect);
	}

	/**
	 * 总和
	 */
	@Test
	public void test9() {
		DoubleSummaryStatistics collect = empLoyees.stream().collect(Collectors.summarizingDouble(EmpLoyee::getMoney));
		System.out.println("collect = " + collect);
	}

	/**
	 * partitioningBy  分区
	 */
	@Test
	public void test8() {
		Map<Boolean, List<EmpLoyee>> collect = empLoyees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
		System.out.println("collect = " + collect);
	}

	@Test
	public void test7() {
		var s = empLoyees.stream().collect(Collectors.groupingBy(EmpLoyee::getStatus, Collectors.groupingBy(e -> {
			if (((EmpLoyee) e).getAge() > 30) {
				return 1;
			} else if (((EmpLoyee) e).getAge() > 50) {
				return 2;
			} else {
				return 3;
			}
		})));
		System.out.println("s = " + s);
	}

	@Test
	public void test6() {//分组
		Map<EmpLoyee.Status, List<EmpLoyee>> collect = empLoyees.stream().collect(Collectors.groupingBy(EmpLoyee::getStatus));
		System.out.println("collect = " + collect);
	}

	@Test
	public void test5() {
		//总数
		Long count = empLoyees.stream().collect(Collectors.counting());
		System.out.println("count = " + count);

		System.out.println("---------------------------------");

		//平均值
		var avg = empLoyees.stream().collect(Collectors.averagingDouble(EmpLoyee::getMoney));
		System.out.println("avg = " + avg);

		//总和
		var sum = empLoyees.stream().collect(Collectors.summarizingDouble(EmpLoyee::getMoney));
		System.out.println("sum = " + sum);

		//最大值
		Optional<EmpLoyee> max = empLoyees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney())));
		System.out.println(max);

		//最小值
		Optional<Double> min = empLoyees.stream().map(EmpLoyee::getMoney).collect(Collectors.minBy(Double::compare));
		System.out.println("min = " + min);
	}

	@Test
	public void test4() {
		var list = empLoyees.stream().map(EmpLoyee::getUsername)
				.collect(Collectors.toList());
		list.forEach(System.out::println);

		System.out.println("-----------------------");


		Set<String> collect = empLoyees.stream().map(EmpLoyee::getUsername)
				.collect(Collectors.toSet());
		collect.forEach(System.out::println);

		System.out.println("--------------------------");
		HashSet<String> collect1 = empLoyees.stream().map(EmpLoyee::getUsername).
				collect(Collectors.toCollection(HashSet::new));
		collect1.forEach(System.out::print);
	}

	/**
	 * 归约
	 * reduce(T identity,BinaryOperator)
	 * reduce(BinaryOperator)
	 * 可以将数据流的只加上返回一个值
	 */
	@Test
	public void test3() {
		List<Long> list = new ArrayList<Long>() {{
			add(1l);
			add(2l);
			add(3l);
			add(4l);
			add(5l);
			add(6l);
			add(7l);
			add(8l);
			add(9l);
			add(10l);
		}};
		var s = list.stream().reduce(0l, (x, y) -> x + y);
		System.out.println("s = " + s);
		System.out.println("------------------------");

		var reduce = empLoyees.stream().map(EmpLoyee::getMoney).reduce(Double::sum);
		System.out.println("reduce = " + reduce);
	}

	/**
	 * 查找与匹配
	 * allMatch ---检查是否匹配所有元素
	 * anyMatch ---检查是否至少匹配一个元素
	 * noneMatch ---检查是否没有匹配所有元素
	 * findFirst ---返回第一个元素
	 * findAny --- 随机返回
	 * count ---返回当前流中元素的总个数
	 * max --- 返回流中最大值
	 * min --- 返回流中最小值
	 */

	@Test
	public void test2() {
		//count
		var count = empLoyees.stream().filter(e -> e.getAge() > 90).count();
		System.out.println("count = " + count);
		//max
		var e4 = empLoyees.stream().filter(e -> e.getAge() > 20).max((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
		System.out.println("e4 = " + e4);

		//min
		var e5 = empLoyees.stream().filter(e -> e.getAge() > 10).min((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
		System.out.println("e5 = " + e5);

		var b = empLoyees.stream().anyMatch(e -> e.getAge().equals(""));
	}


	@Test
	public void test1() {
		//findAny //stream 串行流
		var any = empLoyees.parallelStream().filter(e -> e.getStatus().equals(EmpLoyee.Status.BUSY)).findAny();
		var empLoyee1 = any.get();
		System.out.println("empLoyee1 = " + empLoyee1);
		//findFirst
		var first = empLoyees.stream().sorted((e1, e2) -> -Double.compare(e1.getMoney(), e2.getMoney())).findFirst();
		var empLoyee = first.get();
		System.out.println("empLoyee = " + empLoyee);
		//noneMatch
		var b3 = empLoyees.stream().noneMatch(e -> e.getAge().equals(40));
		System.out.println("b3 = " + b3);
		//allMatch
		var b1 = empLoyees.stream().allMatch(e ->
				e.getStatus().equals(EmpLoyee.Status.BUSY));
		System.out.println("b1 = " + b1);
		//anyMatch
		var b2 = empLoyees.stream().anyMatch(e ->
				e.getStatus().equals(EmpLoyee.Status.BUSY)
		);
		System.out.println("b2 = " + b2);
	}
}
