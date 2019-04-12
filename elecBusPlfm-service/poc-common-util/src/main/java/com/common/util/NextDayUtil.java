package com.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NextDayUtil {

	//根据当前时间获取前days天的日期
	public static Date getNextDay(Date date,int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		date = calendar.getTime();
		return date;
	}
	
	//判断微信群组编辑删除是否在合法时间区间
	public static boolean isLegalTimeInterval(){
		try{
			DateFormat df = new SimpleDateFormat("HH:mm:ss") ;
			
			Date date = df.parse(df.format(new Date())) ;
			
			if(date.after(df.parse("17:30:00"))&&date.before(df.parse("23:59:59"))){
				return false ;
			}else{
				return true ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false ;
	}
}
