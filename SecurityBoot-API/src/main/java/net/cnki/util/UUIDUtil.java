package net.cnki.util;

import java.util.UUID;

/**
 * 
 * @author ZhiPengyu
 * @ClassName:    [UUIDUtil]
 * @Description:  [唯一识别id工具类]
 * @CreateDate:   [2019年8月6日 下午3:49:16]
 */
public class UUIDUtil {
	private static int DYE;
	
	/**
	 * 封装JDK自带的UUID+ASCII码，共33位，中间无-分割.
	 */
	public static String getUUID(){
		if(DYE<48 || DYE>122){
			DYE = 48;
		}else if(DYE>57 && DYE<=65){
			DYE = 65;
		}else if(DYE>90 && DYE<=97){
			DYE = 97;
		}
		//DYE = (DYE<48 || DYE>122)?DYE = 48:((DYE>57 && DYE<=65)?DYE = 65:((DYE>90 && DYE<=97)?DYE = 97:DYE));
		String uuidStr=UUID.randomUUID().toString().replace("-", "")+(char)DYE;
		
		DYE++;
		return uuidStr;
	}
	
}
