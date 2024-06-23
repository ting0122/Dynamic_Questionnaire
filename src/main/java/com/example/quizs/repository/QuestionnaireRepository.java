package com.example.quizs.repository;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizs.entity.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{

	List<Questionnaire> findAll();
	
	Optional<Questionnaire> findById(Long id);

	Optional<Questionnaire> findByNameContaining(String name);

    List<Questionnaire> findByStartDateAfter(LocalDate startDate);

    List<Questionnaire> findByEndDateBefore(LocalDate endDate);

    List<Questionnaire> findByNameAndStartDateAfter(String name, LocalDate startDate);

    List<Questionnaire> findByNameAndEndDateBefore(String name, LocalDate endDate);

    List<Questionnaire> findByNameAndStartDateBetween(String name, LocalDate startDate, LocalDate endDate);
	
}
