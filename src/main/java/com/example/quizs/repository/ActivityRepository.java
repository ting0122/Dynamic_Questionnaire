package com.example.quizs.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizs.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

	List<Activity> findAll();

	Optional<Activity> findByName(String name);

    List<Activity> findByStartTimeAfter(LocalDateTime startTime);

    List<Activity> findByEndTimeBefore(LocalDateTime endTime);

    List<Activity> findByNameAndStartTimeAfter(String name, LocalDateTime startTime);

    List<Activity> findByNameAndEndTimeBefore(String name, LocalDateTime endTime);

    List<Activity> findByNameAndStartTimeBetween(String name, LocalDateTime startTime, LocalDateTime endTime);
	
}
