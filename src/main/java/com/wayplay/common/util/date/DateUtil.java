package com.wayplay.common.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 日期工具类
 * 
 */
public class DateUtil {
	public static final String DEFALT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final int MILLISECONDS_PER_SECOND = 1000;
	public static final int MILLISECONDS_PER_DAY = 86400000;
	public static final int MILLISECONDS_PER_HOUR = 3600000;
	public static final int MILLISECONDS_PER_MINUTE = 60000;

	static {
		// 尝试试从messages_zh_Cn.properties中获取defaultDatePattner.
		try {
			@SuppressWarnings("unused")
			Locale locale = LocaleContextHolder.getLocale();
			// defaultDatePattern =
			// ResourceBundle.getBundle(Constants.MESSAGE_BUNDLE_KEY,
			// locale).getString("date.default_format");
		} catch (MissingResourceException mse) {
			// do nothing
		}
	}

	/**
	 * 获得默认日期格式 date pattern
	 */
	public static String getDatePattern() {
		return DEFALT_DATE_PATTERN;
	}

	/**
	 * 返回预设Format的当前日期字符串
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}

	/**
	 * 使用预设Format格式化Timestamp成字符串
	 */
	public static String format(Timestamp timestamp) {
		return timestamp == null ? "" : format(timestamp, getDatePattern());
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : parse(strDate, getDatePattern());
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个整天
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(date);

			cal.add(Calendar.DAY_OF_MONTH, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cal.getTime();
	}

	/**
	 * 每个月的月底是几号
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastMonthDay(String year, String month) {
		Calendar cal = Calendar.getInstance();
		// 年
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// 月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		// 日，设为一号
		cal.set(Calendar.DATE, 1);
		// 月份加一，得到下个月的一号
		cal.add(Calendar.MONTH, 1);
		// 下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	}

	/*
	 * 把字符串按指定格式转化成Date
	 */
	public static Date strToDate(String aMask, String strDate) {
		SimpleDateFormat format = new SimpleDateFormat(aMask);
		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * 把字符串按默认格式转化成Date
	 */
	public static Date strToDate(String strDate) {
		return strToDate(DEFALT_DATE_PATTERN, strDate);
	}

	/*
	 * 日期相减得到的毫秒数
	 */
	public static long sub(String strBeginDate, String strEndDate) {
		long dateRange = 0;
		Date beginDate = strToDate(strBeginDate);
		Date endDate = strToDate(strEndDate);
		dateRange = endDate.getTime() - beginDate.getTime();
		return dateRange;
	}

	/*
	 * 日期相减得到的毫秒数
	 */
	public static long sub(String aMask, String strBeginDate, String strEndDate) {
		long dateRange = 0;
		Date beginDate = strToDate(aMask, strBeginDate);
		Date endDate = strToDate(aMask, strEndDate);
		dateRange = endDate.getTime() - beginDate.getTime();
		return dateRange;
	}

	/*
	 * 日期相减得到的天数
	 */
	public static String subToDay(String strBeginDate, String strEndDate) {
		String dayNum = "";
		long dateRange = sub(strBeginDate, strEndDate);
		dayNum = "" + (dateRange / MILLISECONDS_PER_DAY);
		return dayNum;
	}

	/*
	 * 日期相减得到的秒数 自定义格式
	 */
	public static String subToSecond(String aMask, String strBeginDate, String strEndDate) {
		String secNum = "";
		long dateRange = sub(aMask, strBeginDate, strEndDate);
		secNum = "" + (dateRange / MILLISECONDS_PER_SECOND);
		return secNum;
	}

	/**
	 * 日期相减得到的秒数 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strBeginDate
	 * @param strEndDate
	 */
	public static String subToSecond(String strBeginDate, String strEndDate) {
		String secNum = "";
		long dateRange = sub("yyyy-MM-dd HH:mm:ss", strBeginDate, strEndDate);
		secNum = "" + (dateRange / MILLISECONDS_PER_SECOND);
		return secNum;
	}

	public static String subToHour(String strBeginDate, String strEndDate) {
		String secNum = "";
		long dateRange = sub("yyyy-MM-dd", strBeginDate, strEndDate);
		secNum = "" + (dateRange / MILLISECONDS_PER_HOUR);
		return secNum;
	}

	/**
	 * 得到当前时间的时间戳
	 * 
	 * @return 当前时间戳
	 */
	public static String getNowTimestamp() {
		// SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		long curTime = System.currentTimeMillis();

		return String.valueOf(curTime);
	}

	/**
	 * 日期类型小时加减计算
	 * 
	 * @param date
	 * @param intervalHours
	 * @return
	 */
	public static Date addHours(Date date, int intervalHours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, intervalHours);
		return calendar.getTime();
	}

	/**
	 * 当月最大天数
	 * 
	 * @param strdate
	 * @return
	 */
	public static int getMaxDay(String strdate) {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat(DEFALT_DATE_PATTERN); // 如果写成年月日的形式的话，要写小d，如："yyyy/MM/dd"
		try {
			rightNow.setTime(simpleDate.parse(strdate)); // 要计算你想要的月份，改变这里即可
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);

		return days;
	}

	/**
	 * 得到yyyy-MM-dd HH:mm:ss 格式的时间字符串 将MongoDB 的日期格式转换为 常见的形式
	 * 
	 */
	public String getFormatDateStr(String dateString) {
		String updateTime = dateString.replace(" ", "");
		try {
			DateUtil.format(DateUtil.parse(updateTime, "DD-MM月-yy"), "yyyy-MM-DD");
			if (StringUtils.isNotBlank(updateTime)) {
				updateTime = DateUtil.format(DateUtil.parse(updateTime, "dd-MM月-yy"), "yyyy-MM-dd");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return updateTime;
	}

	public static void main(String[] args) {
		System.out.println(getToday());
		// System.out.println(getNowTimestamp());
		// 1409818157182
		// System.out.println(subToSecond("1409818157182",
		// System.currentTimeMillis()+""));
		// System.out.println(strToDate("2014-07-21 19:41:55"));
		System.out.println(sub("2014-07-21 19:41:55", "2014-07-21 19:41:56"));
	}

}