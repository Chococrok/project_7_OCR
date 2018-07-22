package io.ab.library.webapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		return dateFormat.format(date);
	}

}
