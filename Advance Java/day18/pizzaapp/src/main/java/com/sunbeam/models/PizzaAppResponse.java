package com.sunbeam.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

enum AppStatus {
	success, error
}

public class PizzaAppResponse<T> {
	private AppStatus status;
	private T data;
	private String message;
	
	public PizzaAppResponse(AppStatus status, T data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}
	
	public AppStatus getStatus() {
		return status;
	}


	public T getData() {
		return data;
	}


	public String getMessage() {
		return message;
	}


	public static <T> PizzaAppResponse<T> success(T data) {
		PizzaAppResponse<T> res = new PizzaAppResponse<T>(AppStatus.success, data, null);
		return res;
	}
	public static <T> PizzaAppResponse<T> success(T data, String message) {
		PizzaAppResponse<T> res = new PizzaAppResponse<T>(AppStatus.success, data, message);
		return res;
	}
	public static <T> PizzaAppResponse<T> error(String message) {
		PizzaAppResponse<T> res = new PizzaAppResponse<T>(AppStatus.error, null, message);
		return res;
	}
}
