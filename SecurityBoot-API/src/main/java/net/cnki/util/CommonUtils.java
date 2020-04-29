package net.cnki.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonUtils {
	 /**
    * 判断字符串是否为NULL或空
    * @param s 字符串
    * @return 如果此map为null或空，则返回 true
    */
   public static  boolean isNotEmpty(Object obj) {
		if (obj instanceof String) {
			if (null != obj && !"".equals(obj))
				return true;
		}
		if (obj instanceof Date) {
			if (null != obj)
				return true;
		}
		if (obj instanceof Integer) {
			if (null != obj)
				return true;
		}
		if (obj instanceof Double) {
			if (null != obj)
				return true;
		}
		return false;
	}
   //去除前后空格
   public static String removeBlank(String string) {
	   if(null != string && !"".equals(string)) {
		   string = string.trim();
	   }
	   return string;
   }
   /**
    * @Description 格式化开始时间
    * @author tkk
    * @param date
    * @return date
    * **/
   public static String formatStartDate(Date date) {
       SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
       return f.format(date);
   }
   
   public static String formatDate(Date date) {
       SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return f.format(date);
   }

   public static Date stringToDate(String date) throws ParseException {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   return formatter.parse(date);
   }
   
   public static Date stringToDateFormat(String date) throws ParseException {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   return formatter.parse(date);
   }
   
   public static long stringToLong(String string) {
		 try {
			 long len = Long.parseLong(string);
			 return len;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return -1;
   }
   
   public static int stringToInt(String string) {
	   try {
		   return Integer.parseInt(string);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return -1;
   }
   
   public static String intToString(int num) {
	   try {
		   return String.valueOf(num);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return null;
   }
   
   public static Double stringToDouble(String string) {
	   try {
		   return Double.parseDouble(string);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return 0.0;
   }
   //根据传入的id字符如：id=1,2,3返回一个int数组
   public static Integer[] getIds(List<String> ids) {
		List<String> list = new ArrayList<String>();
		String [] s = ids.toString().split(",");
		for(String ss:s) {
			list.add(ss);
		}
		Integer[] intArr = new Integer[list.size()];
		for(int a=0;a<list.size();a++){
			String s2 = list.get(a).replace("[", "").replace("]", "");
			intArr[a] = Integer.valueOf(s2); //然后遍历字符串数组，使用包装类Integer的valueOf方法将字符串转为整型
		}
		return intArr;
	}
   
}
