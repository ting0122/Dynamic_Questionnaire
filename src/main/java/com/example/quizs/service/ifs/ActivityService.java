package com.example.quizs.service.ifs;

import com.example.quizs.vo.VoteActivityReq;
import com.example.quizs.vo.VoteActivityRes;

public interface ActivityService {

	VoteActivityRes saveActivity(VoteActivityReq voteActivityReq);
}
