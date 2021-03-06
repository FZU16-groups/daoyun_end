package com.pcs.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应实体
 */
public class ResponseData {
	private final String message;
	private final int code;
	private final Map<String, Object> data = new HashMap<String, Object>();

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public ResponseData putDataValue(String key, Object value) {
		data.put(key, value);
		return this;
	}

	public ResponseData(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static ResponseData ok() {
		return new ResponseData(200, "Ok");
	}

	public static ResponseData notFound() {
		return new ResponseData(404, "Not Found");
	}

	public static ResponseData badRequest() {
		return new ResponseData(400, "Bad Request");
	}

	public static ResponseData forbidden() {
		return new ResponseData(403, "Forbidden");
	}

	public static ResponseData unauthorized() {
		return new ResponseData(401, "unauthorized");
	}

	public static ResponseData serverInternalError() {
		return new ResponseData(500, "Server Internal Error");
	}

	public static ResponseData customerError() {
		return new ResponseData(1001, "custome Error!!!");
	}

	public static ResponseData existError() {
		return new ResponseData(1002, "exist Error!!!");
	}

	public static ResponseData emptyRole() {
		return new ResponseData(1003, "empty Role!!!");
	}

	public static ResponseData deleteError() {
		return new ResponseData(1004, "delete error!!!");
	}


}
