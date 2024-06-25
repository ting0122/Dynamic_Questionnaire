package com.example.quizs.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@ElementCollection
	private List<String> choices;

	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaire questionnaire;	

	//constructor
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Long id, String title, List<String> choices, Questionnaire questionnaire) {
		super();
		this.id = id;
		this.title = title;
		this.choices = choices;
		this.questionnaire = questionnaire;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	public Questionnaire getQuestionnaire(){
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire){
		this.questionnaire = questionnaire;
	}
	
}
