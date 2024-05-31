package com.example.quizs.service.ifs;

import com.example.quizs.vo.UserVoteReq;
import com.example.quizs.vo.UserVoteRes;

public interface UserService {

	UserVoteRes saveUser(UserVoteReq userVoteReq);
	
}	
