package com.lambda.functionimple.optional;

import com.lambda.stream.EmpLoyee;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional: 容器类的常用方法:
 * Optional.of(T t) : 创建一个Optional实例
 * Optional.empty() : 创建一个空的Optional实例
 * Optional.ofNullable(T t) :若 t 不为null,创建optional实例,否则创建空实例
 * isPresent() : 判断是否包含值
 * orElse(T t) : 如果调用对象包含值,返回该值,否则返回t
 * orElseGet(Supplier e) : 如果调用对象包含值,返回该值,否则返回s 获取的值
 * map(Function f) : 如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
 * flatMap(Function mapper) : 与map类似,要求返回值必须是Optional
 */
public class TestOptional {

	@Test
	public void test1() {
		Optional<EmpLoyee> op = Optional.of(new EmpLoyee());
		System.out.println("op = " + op.get());
	}

	@Test
	public void test2() {
		Optional<EmpLoyee> o = Optional.empty();
		System.out.println("o = " + o.get());
	}

	@Test
	public void test3() {
		Optional<EmpLoyee> o = Optional.ofNullable(
				new EmpLoyee(
						"好的",
						43.4, 34l,
						EmpLoyee.Status.FREE)
		);

		if (o.isPresent()) {
			System.out.println(o.get());
			//return;
		}

		/*EmpLoyee test = o.orElse(new EmpLoyee(
				"Test",
				34.4, 43l,
				EmpLoyee.Status.BUSY));
		System.out.println("test = " + test);*/
		EmpLoyee empLoyee = o.orElseGet(() -> new EmpLoyee());
		System.out.println("empLoyee = " + empLoyee);
	}
	@Test
	public void test4(){
		Optional<EmpLoyee> empLoyee = Optional.ofNullable(
				new EmpLoyee(
						"OK", 23.00,
						90l, EmpLoyee.Status.BUSY
				)
		);
		/*Optional<String> s = empLoyee.map(e -> e.getUsername());
		System.out.println("s = " + s);*/

		Optional<String> s = empLoyee.flatMap((e -> Optional.of(
				e.getUsername())));
		System.out.println("s = " + s);
	}
}
