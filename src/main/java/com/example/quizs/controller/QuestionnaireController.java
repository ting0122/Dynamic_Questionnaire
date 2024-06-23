package com.example.quizs.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizs.service.ifs.QuestionnaireService;
import com.example.quizs.vo.QuestionnaireRes;
import com.example.quizs.vo.QuestionnaireReq;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	
	private final QuestionnaireService questionnaireService;
	
	@Autowired
	public QuestionnaireController(QuestionnaireService questionnaireService) {
		this.questionnaireService = questionnaireService;
	}
	
	//search
	@GetMapping
	public QuestionnaireRes search(@RequestParam(value = "id", required = false) Long id,
								  @RequestParam(value = "name", required = false) String name,
								  @RequestParam(value = "startDate", required = false) LocalDate startDate,
								  @RequestParam(value = "endDate", required = false) LocalDate endDate) {
		System.out.println("id :"+ id +"name :"+name+"startDate :"+startDate+"endDate :"+endDate);
		return questionnaireService.searchQuestionnaire(id, name, startDate, endDate);
	}
	
	//add or update
	@PostMapping
	public QuestionnaireRes build(@RequestBody QuestionnaireReq questionnaireReq) {
		return questionnaireService.buildQuestionnaire(questionnaireReq);
	}
	
	//delete
	@DeleteMapping
	public QuestionnaireRes delete(@RequestParam(value = "questionnaireId") Long questionnaireId) {
		return questionnaireService.deleteQuestionnaire(questionnaireId);
	}
	
	
	
}
