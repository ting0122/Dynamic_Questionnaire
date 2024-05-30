package com.example.quizs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizs.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
