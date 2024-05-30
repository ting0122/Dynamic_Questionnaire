package com.example.quizs.vo;

import java.time.LocalDateTime;

public class VoteActivityReq {

	private String name;
	
	private String description;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	//no-argument constructor
	public VoteActivityReq() {
		
	}

	//constructor
	public VoteActivityReq(String name, String description, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.name = name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
}
