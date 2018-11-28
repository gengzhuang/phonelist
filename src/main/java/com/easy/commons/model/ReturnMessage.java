package com.easy.commons.model;

import java.io.Serializable;

/**
 * 
 * @author GengZhuang
 *
 */
public class ReturnMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339966198768223465L;
	/* 是否成功 */
	
	private boolean success;
	/* 返回消息内容 */
	private String message;
	/* 返回消息数据对象 */
	private Object data;

	/**
	 * 构造一个返回状态为true的构造函数
	 * 
	 * @param message
	 *            消息内容
	 */
	public ReturnMessage(String message) {
		this(true, message);
	}

	/**
	 * 构造一个返回状态为true的构造函数
	 * 
	 * @param data
	 *            数据对象
	 */
	public ReturnMessage(Object data) {
		this(true, null, data);
	}

	public ReturnMessage(boolean success, String message) {
		this(success, message, null);
	}

	public ReturnMessage(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	/**
	 * 判断执行操作是否成功
	 * 
	 * @return true：成功；false：失败
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置执行操作是否成功
	 * 
	 * @param success
	 *            true：成功；false：失败
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 得到消息内容
	 * 
	 * @return 消息内容
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置消息内容
	 * 
	 * @param message
	 *            消息内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 得到返回数据对象
	 * 
	 * @return 数据对象
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置返回数据对象
	 * 
	 * @param data
	 *            数据对象
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
