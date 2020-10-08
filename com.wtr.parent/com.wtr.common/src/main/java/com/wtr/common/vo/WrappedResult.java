package com.wtr.common.vo;

import lombok.Data;

@Data
public class WrappedResult<T> {

	private boolean successful;
	private String code;
	private String message;
	private T data;
	
	/**
	 * 成功代码
	 */
	public static final String SUCCESS_CODE = "200";
	
	/**
	 * 无访问权限，请先登录代码
	 */
	public static final String NO_AUTHENTICATION_CODE = "000";
	
	/**
	 * 登录失败代码
	 */
	public static final String LOING_FAULT_CODE = "400";
	
	/**
	 * 无权访问代码
	 */
	public static final String LOING_DENIED_CODE = "300";
	
	/**
	 * 注销代码
	 */
	public static final String LOGOUT_CODE = "100";
	
	private WrappedResult() {
		successful = true;
		code = SUCCESS_CODE;
	}
	
	private WrappedResult(boolean successful, String code, String message, T data) {
		this.successful = successful;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static<E> WrappedResult<E> success(E data) {
		return success(SUCCESS_CODE, "请求成功", data);
	}
	public static<E> WrappedResult<E> success(String code, String message, E data) {
		WrappedResult<E> result = new WrappedResult<>(true, code, message, data);
		return result;
	}
	
}
