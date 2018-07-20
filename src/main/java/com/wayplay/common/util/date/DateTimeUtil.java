package com.wayplay.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateTimeUtil {

	/**1分钟的毫秒数**/
	public static final long ONE_SECOND_TIMEMILLIS = 1L * 60L * 1000L;
	/**5分钟的毫秒数**/
	public static final long FIVE_SECOND_TIMEMILLIS = 5L * 60L * 1000L;
	/**1小时的毫秒数**/
	public static final long ONE_HOUR_TIMEMILLIS = 60L * 60L * 1000L;
	/**1年的毫秒数**/
	public static final long ONE_YEAR_TIMEMILLIS = 365L * 24L * 60L * 60L * 1000L;
	
	public static final String FORMAT_DATE_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取人性化显示时间
	 * @param timeMillis
	 * @return
	 */
	public static String getHumanDisplayTime(String  dateStr){
		Long times=0L;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d= sdf.parse(dateStr);
			times=d.getTime();
		} catch (ParseException e) {
			times=System.currentTimeMillis();
		}
		
		Long currentTimeMillis = System.currentTimeMillis();
		Long timeDifference = currentTimeMillis - times;
		if(timeDifference < ONE_SECOND_TIMEMILLIS){
			return "刚刚";
		}
		if(timeDifference >= ONE_SECOND_TIMEMILLIS && timeDifference < ONE_HOUR_TIMEMILLIS){
			return timeDifference/ONE_SECOND_TIMEMILLIS + "分钟前";
		}
		if(timeDifference >= ONE_HOUR_TIMEMILLIS){
			if(times >= getTodayMorningTimeMillis()){
				return "今天 " + getTodayHourSecond(times);
			}else{
				return getMonthDayHourSecond(times);
			}
		}
		return "";
	}
	
	
	/**
	 * 获取当前凌晨零点的时间戳
	 * @return
	 */
	public static Long getTodayMorningTimeMillis(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
	}
	
	/**
	 * 生成“12:25”格式的时间
	 * @param timeMillis
	 * @return
	 */
	public static String getTodayHourSecond(Long timeMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeMillis);
		return getDisplayDoubleNums(cal.get(Calendar.HOUR_OF_DAY)) + ":"
				+ getDisplayDoubleNums(cal.get(Calendar.MINUTE));
	}
	
	/**
	 * 生成“06月19日 22:39”格式的时间
	 * @param timeMillis
	 * @return
	 */
	public static String getMonthDayHourSecond(Long timeMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeMillis);
		return getDisplayDoubleNums((cal.get(Calendar.MONTH) + 1)) + "月"
				+ getDisplayDoubleNums(cal.get(Calendar.DAY_OF_MONTH)) + "日 "
				+ getDisplayDoubleNums(cal.get(Calendar.HOUR_OF_DAY)) + ":"
				+ getDisplayDoubleNums(cal.get(Calendar.MINUTE));
	}
	
	private static String getDisplayDoubleNums(int num){
		if(num >=0 && num < 10){
			return "0" + num;
		}
		return String.valueOf(num);
	}
	
	/**
	 * 根据出生日期，计算年龄
	 * @param date
	 * @return
	 */
	public static Long getCurrentAge(Long date){		
		return Math.abs((getTodayMorningTimeMillis() - date)/ONE_YEAR_TIMEMILLIS);
	}

	/**
	 * 星座
	 */
	public static final String[] constellationArr = { "魔羯座", "水瓶座", "双鱼座", "牡羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座" };
	
	public static final int[] constellationEdgeDay = { 20, 18, 20, 20, 20, 21, 22, 22, 22, 22, 21, 21 };
	
	/**
	 * 根据月日判断星座
	 * @return 
	 */
	public static String date2Constellation(Calendar time) {
		int month = time.get(Calendar.MONTH);   
	    int day = time.get(Calendar.DAY_OF_MONTH);   
	    if (day < constellationEdgeDay[month]) {   
	        month = month - 1;   
	    }   
	    if (month >= 0) {   
	        return constellationArr[month];   
	    }   
	    //default to return 魔羯   
	    return constellationArr[11];   
	}
	
	/**
	 * 生肖
	 */
	public static final String[] zodiacArr = { "猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊" };
	
	/**  
	 * 根据日期获取生肖  
	 * @return  
	 */  
	public static String date2Zodica(Calendar time) {   
	    return zodiacArr[time.get(Calendar.YEAR) % 12];   
	} 
}
