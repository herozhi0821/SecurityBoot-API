package net.cnki.common;

/**
 * 
 * 1001～1999 区间表示参数错误
 * 2001～2999 区间表示用户错误
 * 3001～3999 区间表示接口异常
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author ZhiPengyu
 * @date: 2020年4月29日 上午9:27:40
 */
public enum ResultCode {
    /* 成功 */
    SUCCESS("200", "Success!"),
    /* 失败 */
    FAIL("400", "Failure!"),
    
    FAIL_TOKEN("5000", "Token信息有误!"),
    
	/* 参考HTTP状态码 */
    NO_PERMISSION("403", "Need Authorities!"),//没有权限
    LOGIN_NO("402", "Need Login!"),//未登录
    LOGIN_FAIL("401", "Login Failure!"),//登录失败
    LOGIN_SUCCESS("200", "Login Success!"),//登录成功
    LOGOUT_SUCCESS("200", "Logout Success!"),//退出登录
    SESSION_EXPIRES("101", "Session Expires!"),//会话到期
    SESSION_EXPIRES_OTHER_LOGIN("101", "Session Expires!Other users login！"),//会话到期,其他用户登录
    
    /* 参数错误：1000～1999 */
    PARAM_NOT_VALID("1001", "参数无效"),
    PARAM_IS_BLANK("1002", "参数为空"),
    PARAM_TYPE_ERROR("1003", "参数类型错误"),
    PARAM_NOT_COMPLETE("1004", "参数缺失"),

    /* 用户错误 */
    USER_NOT_LOGIN("2001", "用户未登录"),
    USER_CREDENTIALS_ERROR("2002", "密码错误"),
    USER_ACCOUNT_LOCKED("2003", "账号被禁用"),
    USER_ACCOUNT_NOT_EXIST("2004", "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST("2005", "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS("2006", "账号下线");

    
    private String code;
    private String message;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	/**
	 * 
	 * @param code
	 * @param message
	 */
    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
