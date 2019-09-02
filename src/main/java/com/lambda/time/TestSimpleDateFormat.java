package com.lambda.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

	/**
	 * 使用ThreadLocal处理线程安全
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> list = new ArrayList<Future<Date>>() {{
			for (int i = 0; i <= 100; i++) {
				add(pool.submit(() -> {
					return SimpleDateFormatLocal.convert("2001010");
				}));
			}
		}};

		for (Future<Date> dateFuture : list) {
			System.out.println(dateFuture.get());
		}
		pool.isShutdown();
		pool.shutdown();
	}

	@Test
	public void test2() throws ExecutionException, InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> list = new ArrayList<Future<Date>>() {{
			for (int i = 0; i < 200; i++) {
				add(pool.submit(() -> {
					return sdf.parse("20011010");
				}));
			}
		}};
		for (Future<Date> dateFuture : list) {
			System.out.println("dateFuture = " + dateFuture.get());
		}
		pool.shutdown();
	}

	@Test
	public void test3() throws ExecutionException, InterruptedException {
		DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyyMMdd");
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<LocalDate>> list = new ArrayList<Future<LocalDate>>() {
			{
				for (int i = 0; i < 20; i++) {
					add(pool.submit(
							() -> {
								return LocalDate.parse("20161218", time);
							}
					));
				}
			}
		};

		for (Future<LocalDate> localDateFuture : list) {
			System.out.println("localDateFuture = " + localDateFuture.get());
		}
	}
}
