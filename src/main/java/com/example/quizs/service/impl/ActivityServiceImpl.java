package com.example.quizs.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizs.constant.ResMsg;
import com.example.quizs.entity.Activity;
import com.example.quizs.repository.ActivityRepository;
import com.example.quizs.service.ifs.ActivityService;
import com.example.quizs.vo.SearchRes;
import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final ActivityRepository activityRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}
	
	//search activity
	@Override
	public SearchRes searchActivity(String activityName,LocalDateTime startTime,LocalDateTime endTime) {

		//time validation
		//if both time is not null
		if(startTime != null && endTime != null) {
			if(endTime.isBefore(startTime)) {
				return new SearchRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
			}
		}
		
		
		//activities container
		List<Activity> activities;
		
		//find all activities
		if(activityName == null && startTime == null && endTime == null) {
			activities = activityRepository.findAll();
		}
		//only activity name is existed
		else if(activityName != null && startTime == null && endTime == null) {
			activities = activityRepository.findByName(activityName).map(List::of).orElse(List.of());
		}
		//activity name and start time is existed
		else if(activityName != null && startTime != null && endTime == null) {
			activities = activityRepository.findByNameAndStartTimeAfter(activityName, startTime);
		}
		//activity name and end time is existed
		else if(activityName != null && startTime == null && endTime != null) {
			activities = activityRepository.findByNameAndEndTimeBefore(activityName, endTime);
		}
		//only start time is existed
		else if(activityName == null && startTime != null && endTime == null) {
			activities = activityRepository.findByStartTimeAfter(startTime);
		}
		//only end time is existed
		else if(activityName == null && startTime == null && endTime != null) {
			activities = activityRepository.findByEndTimeBefore(endTime);
		}
		//find specify activity fixed time range
		else {
			activities = activityRepository.findByNameAndStartTimeBetween(activityName, startTime, endTime);
		}
		return new SearchRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription(), activities);
	}
	
	//add or update activity
	@Override
	public VoteActivityRes buildActivity(VoteActivityReq voteActivityReq) {
		
		//validate the time request if is null
		if(voteActivityReq.getStartTime() == null || voteActivityReq.getEndTime() == null) {
			return new VoteActivityRes(ResMsg.BAD_REQUEST.getCode(),ResMsg.BAD_REQUEST.getDescription());
		}
		//validate days between start time and end time
		if(!validateDates(voteActivityReq.getStartTime(), voteActivityReq.getEndTime())) {
			return new VoteActivityRes(ResMsg.BAD_REQUEST.getCode(), ResMsg.BAD_REQUEST.getDescription());
		}
		
		
		Optional<Activity> existingActivityOpt = activityRepository.findByName(voteActivityReq.getName());
		
		//New a activity entity
		Activity activity;
		
		//Value object covert to Entity
		if(existingActivityOpt.isPresent()) {
			activity = existingActivityOpt.get();;
		} else {
			activity = new Activity();
		}
		
		
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
	
	//delete activity
	@Override
	public VoteActivityRes deleteActivity(Long activityId) {
		if(activityRepository.existsById(activityId)) {
			activityRepository.deleteById(activityId);
			return new VoteActivityRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription());
		} else {
			return new VoteActivityRes(ResMsg.NOT_FOUND.getCode(), ResMsg.NOT_FOUND.getDescription());
		}
	}
	
	//validation function
	private boolean validateDates(LocalDateTime startTime, LocalDateTime endTime) {
		return !startTime.isBefore(LocalDateTime.now()) && !endTime.isAfter(startTime.plusDays(7)) && !endTime.isBefore(startTime);
	}
}
