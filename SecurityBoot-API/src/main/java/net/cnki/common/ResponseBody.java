package net.cnki.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @Description: 统一API响应结果封装
 * @author ZhiPengyu
 * @date: 2020年4月29日 下午2:48:18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)//使此字段无值时不显示
public class ResponseBody implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1886106011131539131L;
	
	private String code;
    private String message;
    //@JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})//使此字段无值时值为null
    private Object data;
    
	/* set and get */
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
 
    public Object getData() {
        return data;
    }
 
    public void setData(Object data) {
        this.data = data;
    }
    
	/* 构造 */
    public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

    public ResponseBody(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
     * 默认成功或者失败,无数据
     * @param resultCode
     */
	public ResponseBody(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
	
	/**
	 * 枚举结果以及获取数据
	 * @param resultCode
	 * @param data
	 */
	public ResponseBody(ResultCode resultCode,String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }
	
	/**
	 * 枚举结果以及获取数据
	 * @param resultCode
	 * @param data
	 */
	public ResponseBody(ResultCode resultCode,Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}