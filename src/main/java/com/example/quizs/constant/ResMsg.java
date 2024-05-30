package com.example.quizs.constant;

public enum ResMsg {
	SUCCESS(200, "Vote submitted successfully"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "NOT FOUND"),
	INTERNAL_SERVERE_ERROR(500, "Internal server error");
	
	private final int code;
	private final String description;
	
	ResMsg(int code, String description){
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
}
