package com.lambda.functionimple;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;
/**
 * 方法引用:若Lambda 体中的内容有方法已经实现了,我们可以使用"方法引用"
 * (可以理解为方法引用是lambda 表达式的另外一种表达形式)
 * <p>
 * 主要有三种语法格式:
 * <p>
 * 对象::实例方法名
 * <p>
 * 类::静态方法名
 * <p>
 * 类::实例方法名
 * <p>
 * 注意 :
 * Lambda 体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表
 * 和返回值类型保持一致
 * <p>
 * 若Lambda 参数列表中的第一个参数是实例方法的调用者,
 * 而第二个参数是实例方法的参数时,可以使用className: method
 *
 *
 * 二. 构造器引用:
 *   格式:
 *
 *   ClassName::new
 *
 *   注意:需要调用构造器的参数列表和函数式接口中抽象方法列表保持一致
 *
 * 三. 数组引用:
 *  Type[]::new;
 */
public class Example02 {


	/**
	 * 数组的引用;
	 */
	@Test
	public void test8(){
		Function<Integer, String[]> s = (x)->new String[x];
		int length = s.apply(20).length;
		System.out.println("length = " + length);

		Function<Integer,String[]> c = String[]::new;
		int length1 = c.apply(90).length;
		System.out.println("length1 = " + length1);
	}


	/**
	 * 两个参数构造器
	 */
	@Test
	public void test7(){

		BiFunction<String,String,Andy> f = Andy::new;
		BiFunction<String,String,Andy> f2 = (x,y)->new Andy(x,y);
		Andy apply = f2.apply("34", "34");
		System.out.println("apply = " + apply);


	}

	/**
	 * 构造器引用(有参数,单个参数)
	 */
	@Test
	public void test6(){
		Function<String,Andy> function = (x) -> new Andy(x){{
			setUsername("54544");
			setPassword("afdsfd");
		}};
		System.out.println("function = " + function.apply("34"));
	}

	/**
	 * 构造器引用(无参数)
	 */
	@Test
	public void test5() {
		Supplier<Andy> andySupplier = ()->new Andy(){{
			setPassword("34");
			setUsername("3434");
		}};
		System.out.println("andySupplier = " + andySupplier.get());

		Supplier<Andy> andy=  Andy::new;
	}


	@Test
	public void test4() {
		BiPredicate bp = (x, y) -> x.equals(y);
		boolean test = bp.test("1", "4");
		System.out.println("test = " + test);
	}

	@Test
	public void test3() {
		Employee build = Employee.builder().age(12).password("34").build();
		System.out.println("build = " + build);
		Comparator<Employee> emp =
				(e, e2) -> Integer.compare(e.getAge(), e2.getAge());
		int compare = emp.compare(Employee.builder().age(99).build(), Employee.builder().age(9090).build());
		System.out.println("compare = " + compare);
	}

	/**
	 * 对象::实例方法名
	 */
	@Test
	public void test1() {
		Consumer<String> consumer1 = (x) -> System.out.println(x);
		System.out.println("consumer1 = " + consumer1);

		Consumer<String> consumer2 = System.out::println;
		consumer1.accept("34");
	}

	/**
	 * 对象::实例方法名
	 */
	@Test
	public void test2() {

		//1.
		/*Employee employee = new Employee();
		Supplier<String> su = () -> employee.getPassword();
		String s = su.get();
		System.out.println("s = " + s);
		//2.
		Supplier<String> sup = employee::getUsername;
		String s1 = sup.get();
		System.out.println("s1 = " + s1);*/
	}
}
