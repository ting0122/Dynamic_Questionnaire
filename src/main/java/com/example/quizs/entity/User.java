package com.example.quizs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String mail;
	
	@Column
	private int age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ResponseAnswer> responseAnswers;

	public User() {
	}

	public User(Long id, String name, String phone, String mail, int age, List<ResponseAnswer> responseAnswer) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.responseAnswers = responseAnswer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<ResponseAnswer> getResponseAnswer() {
		return responseAnswers;
	}

	public void setResponseAnswer(List<ResponseAnswer> responseAnswer) {
		this.responseAnswers = responseAnswer;
	}

	
	
}
