package com.example.quizs.service.impl;

import org.springframework.stereotype.Service;

import com.example.quizs.constant.ResMsg;
import com.example.quizs.entity.User;
import com.example.quizs.repository.UserRepository;
import com.example.quizs.service.ifs.UserService;
import com.example.quizs.vo.UserVoteReq;
import com.example.quizs.vo.UserVoteRes;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserVoteRes saveUser(UserVoteReq userVoteReq) {
		
		//validate the request
		if(!isValidUserVoteReq(userVoteReq)) {
			return new UserVoteRes(400,ResMsg.BAD_REQUEST.getDescription());
		}
		
		//user request value object to user entity
		User user = new User();
		user.setName(userVoteReq.getName());
        user.setPhone(userVoteReq.getPhone());
        user.setMail(userVoteReq.getMail());
        user.setAge(userVoteReq.getAge());
        
        //save entity
		userRepository.save(user);
		
		//return success
		return new UserVoteRes(200, ResMsg.SUCCESS.getDescription());
	}
	
	
	//validation function
	private boolean isValidUserVoteReq(UserVoteReq userVoteReq) {
		//validate if request is null
		return userVoteReq != null
				&& userVoteReq.getName() != null && !userVoteReq.getName().isEmpty()
				&& userVoteReq.getPhone() != null && !userVoteReq.getPhone().isEmpty()
				&& isValidMail(userVoteReq.getMail())
				&& userVoteReq.getAge() > 0 ;
	}
	
	//email validation function
	private boolean isValidMail(String mail) {
		String mailRegex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
		return mail.matches(mailRegex);
	}
	
}
