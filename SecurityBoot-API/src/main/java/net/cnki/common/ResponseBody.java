package net.cnki.common;

import java.io.Serializable;

/**
 * 
 * @Description: 统一返回实体
 * @author ZhiPengyu
 * @date: 2020年4月29日 下午2:48:18
 */
public class ResponseBody implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1886106011131539131L;
	
	private String status;
    private String msg;
    private Object result;
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public Object getResult() {
        return result;
    }
 
    public void setResult(Object result) {
        this.result = result;
    }
 
}