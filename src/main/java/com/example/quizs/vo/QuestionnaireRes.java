package com.example.quizs.vo;

import java.util.List;

import com.example.quizs.entity.Questionnaire;

public class QuestionnaireRes {

	private int code;
	private String message;
	private Questionnaire questionnaire;
	private List<Questionnaire> questionnaires;
	
	public QuestionnaireRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionnaireRes(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public QuestionnaireRes(int code, String message, Questionnaire questionnaire) {
		this.code = code;
		this.message = message;
		this.questionnaire = questionnaire;
	}
	
	public QuestionnaireRes(int code, String message, List<Questionnaire> questionnaires) {
		this.code = code;
		this.message = message;
		this.questionnaires = questionnaires;
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
	
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setActivities(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
}
