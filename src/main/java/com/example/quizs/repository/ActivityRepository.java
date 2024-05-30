package com.example.quizs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizs.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

}
