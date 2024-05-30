package com.example.quizs.service.impl;

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
		
		//validation
		
		
		//Value object to Entity
		Activity activity = new Activity();
		activity.setName(voteActivityReq.getName());
		activity.setDescription(voteActivityReq.getDescription());
		activity.setStartTime(voteActivityReq.getStartTime());
		activity.setEndTime(voteActivityReq.getEndTime());
		
		//save entity
		activityRepository.save(activity);
		
		//response
		return new VoteActivityRes(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getDescription());
	}
}
