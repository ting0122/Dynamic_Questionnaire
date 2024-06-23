package com.example.quizs.vo;

import java.util.List;

public class QuestionnaireReq {

	private Long id;
	
	private String userName;
	
	private String phone;
	
	private String email;
	
	private int age;
	
	private Questionnaire questionnaire;
	
	private List<Question> questions;
	
	//no-argument constructor
	public QuestionnaireReq() {
		
	}

	public QuestionnaireReq(Long id, String userName, String phone, String email, int age, Questionnaire questionnaire,
			List<Question> questions) {
		super();
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.questionnaire = questionnaire;
		this.questions = questions;
	}

	//getters and setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	// Nested Questionnaire class
    public static class Questionnaire {
    	private Long id;
        private String name;
        private String description;
        private String startDate;
        private String endDate;
        private boolean published;

        // No-argument constructor
        public Questionnaire() {}

        // All-argument constructor
        public Questionnaire(Long id, String name, String description, String startDate, String endDate, boolean published) {
            this.id = id;
        	this.name = name;
            this.description = description;
            this.startDate = startDate;
            this.endDate = endDate;
            this.published = published;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public boolean isPublished() {
			return published;
		}

		public void setPublished(boolean published) {
			this.published = published;
		}

    }

    // Nested Question class
    public static class Question {
        private String questionText;
        private List<String> choices;
        private String type;
        private boolean required;

        // No-argument constructor
        public Question() {}

        // All-argument constructor
        public Question(String questionText, List<String> choices, String type, boolean required) {
            this.questionText = questionText;
            this.choices = choices;
            this.type = type;
            this.required = required;
        }

		public String getQuestionText() {
			return questionText;
		}

		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}

		public List<String> getChoices() {
			return choices;
		}

		public void setChoices(List<String> choices) {
			this.choices = choices;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public boolean isRequired() {
			return required;
		}

		public void setRequired(boolean required) {
			this.required = required;
		}

    }
}

	