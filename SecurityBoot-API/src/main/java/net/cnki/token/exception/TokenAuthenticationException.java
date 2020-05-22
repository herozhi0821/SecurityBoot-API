package net.cnki.token.exception;

public class TokenAuthenticationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -247462351105955267L;
	private String message;
	
	public TokenAuthenticationException(String message) {
		this.message= message;
	}
	public String getMsg() {
		return message;
	}
}
