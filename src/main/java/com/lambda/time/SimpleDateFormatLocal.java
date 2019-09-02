package com.lambda.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatLocal {
	private static ThreadLocal<DateFormat> local =
			new ThreadLocal<DateFormat>() {
				@Override
				protected DateFormat initialValue() {
					return new SimpleDateFormat("yyyyMMdd");
				}
			};

	public static Date convert(String source) throws ParseException {
		return local.get().parse(source);
	}
}
