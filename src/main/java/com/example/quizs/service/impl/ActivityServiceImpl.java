package com.example.quizs.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.quizs.constant.ResMsg;
import com.example.quizs.entity.Activity;
import com.example.quizs.repository.ActivityRepository;
import com.example.quizs.service.ifs.ActivityService;
import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

public class ActivityServiceImpl implements ActivityService {

	private final ActivityRepository activityRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}
	
	@Override
	public VoteActivityRes saveActivity(VoteActivityReq voteActivityReq) {
		
		//validate the time request if is null
		if(voteActivityReq.getStartTime() == null || voteActivityReq.getEndTime() == null) {
			return new VoteActivityRes(ResMsg.BAD_REQUEST.getCode(),ResMsg.BAD_REQUEST.getDescription());
		}
		//validate days between start time and end time
		if(!validateDates(voteActivityReq.getStartTime(), voteActivityReq.getEndTime())) {
			return new VoteActivityRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
		}
		
		
		//Value object to Entity
		Activity activity = new Activity();
		activity.setName(voteActivityReq.getName());
		activity.setQuestions(voteActivityReq.getQuestions());
		activity.setDescription(voteActivityReq.getDescription());
		activity.setStartTime(voteActivityReq.getStartTime());
		activity.setEndTime(voteActivityReq.getEndTime());
		activity.setPublished(voteActivityReq.isPublished());
		
		//save entity
		activityRepository.save(activity);
		
		//response
		return new VoteActivityRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription());
	}
	
	//validation function
	private boolean validateDates(LocalDateTime startTime, LocalDateTime endTime) {
		return !startTime.isBefore(LocalDateTime.now()) && !endTime.isAfter(startTime.plusDays(7)) && !endTime.isBefore(startTime);
	}
}
