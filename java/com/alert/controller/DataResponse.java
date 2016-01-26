package com.alert.controller;

import java.io.Serializable;

public class DataResponse implements Serializable {
	public static final String R_SUCESS = "success";
	public static final String R_FAILED = "failed";
	private String result;
	private String message;
	private Object data;
	private long totalCount;
	private String code;

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}