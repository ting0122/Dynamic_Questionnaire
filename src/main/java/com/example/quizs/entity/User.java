package com.example.quizs.entity;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;

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
	
	@ElementCollection
	@CollectionTable(name = "response_answers", joinColumns = @JoinColumn(name = "response_id"))
	@MapKeyColumn(name = "question_id")
	@Column(name = "answer")
	private Map<Long, String> answers;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String phone, String mail, int age, Map<Long, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.answers = answers;
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

	public Map<Long, String> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Long, String> answers) {
		this.answers = answers;
	}
	
}
