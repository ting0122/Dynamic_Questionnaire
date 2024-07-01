package com.example.quizs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;

	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Choice> choices;

	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaire questionnaire;	

	//constructor
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Long id, String title, List<Choice> choices, Questionnaire questionnaire) {
		this.id = id;
		this.title = title;
		this.choices = choices;
		this.questionnaire = questionnaire;
	}

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

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> list) {
		this.choices = list;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	
}
