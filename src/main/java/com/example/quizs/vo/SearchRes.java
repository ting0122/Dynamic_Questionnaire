package com.example.quizs.vo;

import java.util.List;

import com.example.quizs.entity.Activity;

public class SearchRes {

	private int code;
	private String message;
	private List<Activity> activities;
	
	public SearchRes(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public SearchRes(int code, String message,List<Activity> activities) {
		this.code = code;
		this.message = message;
		this.activities = activities;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
