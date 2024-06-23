package com.example.quizs.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizs.constant.ResMsg;
import com.example.quizs.entity.Questionnaire;
import com.example.quizs.entity.Question;
import com.example.quizs.repository.QuestionnaireRepository;
import com.example.quizs.service.ifs.QuestionnaireService;
import com.example.quizs.vo.QuestionnaireReq;
import com.example.quizs.vo.QuestionnaireRes;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	private final QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	public QuestionnaireServiceImpl(QuestionnaireRepository questionnaireRepository) {
		this.questionnaireRepository = questionnaireRepository;
	}
	
	//search activity
	@Override
	public QuestionnaireRes searchQuestionnaire(Long id, String name,LocalDate startDate,LocalDate endDate) {
		
		if(id != null) {
			Optional<Questionnaire> Opt = questionnaireRepository.findById(id);
				System.out.println(Opt.get());
				if(Opt.isPresent()) {	
					return new QuestionnaireRes(ResMsg.SUCCESS.getCode(),ResMsg.SUCCESS.getDescription(), Opt.get());
				} else {
					return new QuestionnaireRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
				}
		}
		
		//time validation
		//if both time is not null
		if(startDate != null && endDate != null) {
			if(endDate.isBefore(startDate)) {
				return new QuestionnaireRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
			}
		}
		
//		System.out.println("name :"+name+"startDate :"+startDate+"endDate :"+endDate);
		
		//activities container
		List<Questionnaire> questionnaires;
		
		//find all activities
		if(name == null && startDate == null && endDate == null) {
			questionnaires = questionnaireRepository.findAll();
		}
		//only activity name is existed
		else if(name != null && startDate == null && endDate == null) {
			questionnaires = questionnaireRepository.findByNameContaining(name).map(List::of).orElse(List.of());
		}
		//activity name and start time is existed
		else if(name != null && startDate != null && endDate == null) {
			questionnaires = questionnaireRepository.findByNameAndStartDateAfter(name, startDate);
		}
		//activity name and end time is existed
		else if(name != null && startDate == null && endDate != null) {
			questionnaires = questionnaireRepository.findByNameAndEndDateBefore(name, endDate);
		}
		//only start time is existed
		else if(name == null && startDate != null && endDate == null) {
			questionnaires = questionnaireRepository.findByStartDateAfter(startDate);
		}
		//only end time is existed
		else if(name == null && startDate == null && endDate != null) {
			questionnaires = questionnaireRepository.findByEndDateBefore(endDate);
		}
		//find specify activity fixed time range
		else {
			questionnaires = questionnaireRepository.findByNameAndStartDateBetween(name, startDate, endDate);
		}
		return new QuestionnaireRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription(), questionnaires);
	}
	
	//add or update activity
	@Override
	public QuestionnaireRes buildQuestionnaire(QuestionnaireReq questionnaireReq) {
		
		//validate the time request if is null
		if(questionnaireReq.getQuestionnaire().getStartDate() == null || questionnaireReq.getQuestionnaire().getEndDate() == null){
			return new QuestionnaireRes(ResMsg.BAD_REQUEST.getCode(),ResMsg.BAD_REQUEST.getDescription());
		}
		
		//covert dates
		LocalDate startTime = LocalDate.parse(questionnaireReq.getQuestionnaire().getStartDate());
		LocalDate endTime = LocalDate.parse(questionnaireReq.getQuestionnaire().getEndDate());
		
		//validate days between start time, end time
		 if (ChronoUnit.DAYS.between(startTime, endTime) < 0) {
	            return new QuestionnaireRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
	     }
		
		Optional<Questionnaire> existingActivityOpt = questionnaireRepository.findById(questionnaireReq.getQuestionnaire().getId());
		
		//New a activity entity
		Questionnaire questionnaire;
		
		//Value object covert to Entity
		if(existingActivityOpt.isPresent()) {
			questionnaire = existingActivityOpt.get();;
		} else {
			questionnaire = new Questionnaire();
		}
		
		
		questionnaire.setName(questionnaireReq.getQuestionnaire().getName());
		questionnaire.setDescription(questionnaireReq.getQuestionnaire().getDescription());
		questionnaire.setStartDate(startTime);
		questionnaire.setEndDate(endTime);
		questionnaire.setPublished(questionnaireReq.getQuestionnaire().isPublished());
        
		//Convert List<Questionnaire.Question> to List<String>
		List<Question> questionList = questionnaireReq.getQuestions().stream()
				.map(q -> new Question(null, q.getQuestionText(),q.getChoices()))
				.collect(Collectors.toList());
		questionnaire.setQuestions(questionList);
		
		//save entity
		questionnaireRepository.save(questionnaire);
		
		//response
		return new QuestionnaireRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription());
	}
	
	//delete activity
	@Override
	public QuestionnaireRes deleteQuestionnaire(Long questionnaireId) {
		if(questionnaireRepository.existsById(questionnaireId)) {
			questionnaireRepository.deleteById(questionnaireId);
			return new QuestionnaireRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription());
		} else {
			return new QuestionnaireRes(ResMsg.NOT_FOUND.getCode(), ResMsg.NOT_FOUND.getDescription());
		}
	}
}
