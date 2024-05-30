package com.example.quizs.vo;

import java.time.LocalDateTime;
import java.util.List;

public class VoteActivityReq {

	private String name;
	
	private String description;
	
	private List<String> questions;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private boolean published;
	
	//no-argument constructor
	public VoteActivityReq() {
		
	}

	//constructor
	public VoteActivityReq(String name, String description, List<String> questions, LocalDateTime startTime, LocalDateTime endTime, boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.questions = questions;
		this.startTime = startTime;
		this.endTime = endTime;
		this.published = published;
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
	
	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
}
