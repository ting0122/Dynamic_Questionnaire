package com.example.quizs.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizs.service.ifs.ActivityService;
import com.example.quizs.vo.SearchRes;
import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

@RestController
public class ActivityController {
	
	private final ActivityService activityService;
	
	@Autowired
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	//search activity
	@GetMapping("/activity/search")
	public SearchRes search(@RequestParam(value = "activityName", required = false) String activityName,
								  @RequestParam(value = "startTime", required = false) LocalDateTime startTime,
								  @RequestParam(value = "endTime", required = false) LocalDateTime endTime) {
		return activityService.searchActivity(activityName, startTime, endTime);
	}
	
	//add or update activity
	@PostMapping("/activity/build")
	public VoteActivityRes build(@RequestBody VoteActivityReq voteActivityReq) {
		return activityService.buildActivity(voteActivityReq);
	}
	
	//delete activity
	@DeleteMapping("/activity/delete")
	public VoteActivityRes delete(@RequestParam(value = "activityId") Long activityId) {
		return activityService.deleteActivity(activityId);
	}
	
	
	
}
