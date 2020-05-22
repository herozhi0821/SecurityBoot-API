package net.cnki.redis;

/**
 * 
 * @author ZhiPengyu
 * @ClassName:    [RedisConstants]
 * @Description:  [此类用于区分redis的库]
 * @CreateDate:   [2019年12月20日 下午2:17:19]
 */
public class RedisConstants {
	
	public static final String spilt=":";
	
	/**
	 * redis库0  此库不指定存储专门数据，用于存储定时失效数据或缓存数据，库1及以后用于存储指定类数据
	 */
	private static final Integer datebase0=0;

	/**
	 * redis库1  
	 */
	public static final Integer datebase1=1;

	/**
	 * redis库2 
	 */
	public static final Integer datebase2=2;

	/**
	 * redis库3 
	 */
	public static final Integer datebase3=3;

	/**
	 * redis库4 
	 *
	 */
	public static final Integer datebase4=4;

	/**
	 * redis库5 
	 */
	public static final Integer datebase5=5;

	/**
	 * redis库6 
	 */
	public static final Integer datebase6=6;

	/**
	 * redis库7 
	 */
	public static final Integer datebase7=7;

	/**
	 * redis库8 
	 */
	public static final Integer datebase8=8;

	
	public RedisConstants() {

	}
}
