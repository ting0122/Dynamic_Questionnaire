package com.example.quizs.service.ifs;

import java.time.LocalDateTime;

import com.example.quizs.vo.SearchRes;
import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

public interface ActivityService {

	//search
	SearchRes searchActivity(String activityName,LocalDateTime startTime,LocalDateTime endTime);
	//add or update
	VoteActivityRes buildActivity(VoteActivityReq voteActivityReq);
	//delete
	VoteActivityRes deleteActivity(Long activityId);
	
}
