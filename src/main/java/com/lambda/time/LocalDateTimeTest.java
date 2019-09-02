package com.lambda.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Set;

public class LocalDateTimeTest {

	@Test
	public void test8(){
		LocalDateTime now = LocalDateTime.now(ZoneId.of("US/Pacific"));
		System.out.println("now = " + now);

		ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("US/Pacific"));
		System.out.println("zonedDateTime = " + zonedDateTime);
	}

	@Test
	public void test7(){
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		availableZoneIds.forEach(System.out::println);
	}

	/**
	 * DateTimeFormatter
	 */
	@Test
	public void test6() {
		DateTimeFormatter date = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now = " + now);
		String format = now.format(date);
		System.out.println("format = " + format);

		System.out.println("------------------------------------");

		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format1 = now.format(pattern);
		System.out.println("format1 = " + format1);
		LocalDateTime parse = LocalDateTime.parse(format1, pattern);
	}

	/**
	 * TemporalAdjuster: 时间校正器
	 */
	@Test
	public void test5() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now = " + now);
		LocalDateTime localDateTime = now.withDayOfMonth(10);
		System.out.println("localDateTime = " + localDateTime);

		LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("with = " + with);

		//自定义: 下一个工作日
		LocalDateTime c = now.with((l) -> {
			LocalDateTime ld = (LocalDateTime) l;
			DayOfWeek day = ld.getDayOfWeek();
			if (day.equals(DayOfWeek.FRIDAY)) {
				return ld.plusDays(3);
			} else if (DayOfWeek.SATURDAY.equals(day)) {
				return ld.plusDays(2);
			} else {
				return ld.plusDays(1);
			}
		});
		System.out.println("c = " + c);

	}


	//3.

	/**
	 * Duration : 计算两个 "时间" 之间的间隔
	 * Period : 计算两个 "日期" 之间的间隔
	 */
	public @Test
	void test4() {
		LocalDate dl1 = LocalDate.of(2015, 1, 1);
		LocalDate dl2 = LocalDate.now();

		Period between = Period.between(dl1, dl2);
		System.out.println("between = " + between);
	}

	public @Test
	void test3() {
		Instant instant = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant now = Instant.now();
		Duration between = Duration.between(instant, now);
		System.out.println
				("between.toMillis() = "
						+ between.toMillis());
		//System.out.println("between = " + between);

		LocalTime lt1 = LocalTime.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalTime now1 = LocalTime.now();

		System.out.println("Duration.between(lt1,now1) = "
				+ Duration.between(lt1, now1).toMillis());
	}

	//2.Instant: 时间戳(以Unix 元年: 1970/1/1 00:00:00开始)
	@Test
	public void test2() {
		Instant now = Instant.now();
		System.out.println("now = " + now);

		OffsetDateTime offset = now.atOffset(ZoneOffset.ofHours(8));

		System.out.println("offset = " + offset);
		System.out.println("now = " + now.toEpochMilli());

		Instant milli = Instant.ofEpochMilli(60);
		System.out.println("milli = " + milli);


	}

	@Test
	public void test1() {
		LocalDateTime time = LocalDateTime.now();
		System.out.println("time = " + time);

		LocalDateTime of = LocalDateTime.of(2015, 10
				, 19, 13, 22, 33);
		System.out.println("of = " + of);

		//年
		LocalDateTime localDateTime = time.plusYears(2);
		System.out.println("localDateTime = " + localDateTime);

		//月
		LocalDateTime localDateTime1 = time.plusMonths(2);
		System.out.println("localDateTime1 = " + localDateTime1);

		//周
		LocalDateTime localDateTime2 = time.plusWeeks(1);
		System.out.println("localDateTime2 = " + localDateTime2);
		//日
		LocalDateTime localDateTime3 = time.plusDays(3);
		System.out.println("localDateTime3 = " + localDateTime3);

		//时
		LocalDateTime localDateTime4 = time.plusHours(20);
		System.out.println("localDateTime4 = " + localDateTime4);

		//分
		LocalDateTime localDateTime5 = time.plusMinutes(22);
		System.out.println("localDateTime5 = " + localDateTime5);
		//秒
		LocalDateTime localDateTime6 = time.plusSeconds(10000);
		System.out.println("localDateTime6 = " + localDateTime6);

		//纳秒
		LocalDateTime localDateTime7 = time.plusNanos(10000);
		System.out.println("localDateTime7 = " + localDateTime7);

		long aLong = time.getLong(ChronoField.NANO_OF_SECOND);
		System.out.println("aLong = " + aLong);
	}
}
