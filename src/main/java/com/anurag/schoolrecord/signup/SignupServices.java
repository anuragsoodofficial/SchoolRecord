package com.anurag.schoolrecord.signup;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.User;
import com.anurag.schoolrecord.database_entities.UserRepository;

@Service
public class SignupServices {
	@Autowired
	private UserRepository userRepository;
	
	public ArrayList<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
		userRepository.save(user);
	}
	
	public Iterable<User> getAllUser(){
		return userRepository.findAll();
	}
}
