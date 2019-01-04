package com.bootdo.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class Result extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public Result() {
		put("code", 0);
		put("msg", "操作成功");
	}

	public static Result error() {
		return error(1, "操作失败");
	}

	public static Result error(String msg) {
		return error(500, msg);
	}

	public static Result error(int code, String msg) {
		Result Result = new Result();
		Result.put("code", code);
		Result.put("msg", msg);
		return Result;
	}

	public static Result ok(String msg) {
		Result Result = new Result();
		Result.put("msg", msg);
		return Result;
	}

	public static Result ok(Map<String, Object> map) {
		Result Result = new Result();
		Result.putAll(map);
		return Result;
	}

	public static Result ok() {
		return new Result();
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
