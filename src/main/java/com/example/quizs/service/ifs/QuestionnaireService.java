package com.example.quizs.service.ifs;

import java.time.LocalDate;

import com.example.quizs.vo.QuestionnaireRes;
import com.example.quizs.vo.QuestionnaireReq;

public interface QuestionnaireService {

	//search
	QuestionnaireRes searchQuestionnaire(Long id, String name,LocalDate startDate,LocalDate endDate);
	//add or update
	QuestionnaireRes buildQuestionnaire(QuestionnaireReq questionnaireReq);
	//delete
	QuestionnaireRes deleteQuestionnaire(Long questionnaireId);
	
}
