package com.example.quizs.vo;

import java.util.List;

public class UserVoteReq {

	//User Personal Information
	private String name;
	
	private String phone;
	
	private String mail;
	
	private int age;
	
	//Voted Information
	private List<String> choices;
	
	private String comments;
	
	//constructors
	public UserVoteReq() {
		
	}
	
	public UserVoteReq(String name, String phone, String mail, int age, List<String> choices, String comments) {
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.choices = choices;
		this.comments = comments;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
