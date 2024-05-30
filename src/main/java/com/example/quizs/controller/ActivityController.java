package com.example.quizs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizs.service.ifs.ActivityService;
import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

@RestController
public class ActivityController {
	
	private final ActivityService activityService;
	
	@Autowired
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	@PostMapping("/activity")
	public VoteActivityRes submit(@RequestBody VoteActivityReq voteActivityReq) {
		return activityService.saveActivity(voteActivityReq);
	}
	
}
