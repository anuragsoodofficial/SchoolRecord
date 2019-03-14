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
		if(!user.getFirstName().contains(" ") && !user.getLastName().contains(" ")) {
			users.add(user);
			userRepository.save(user);
		}else if(user.getFirstName().contains(" ") && user.getLastName().contains(" ")) {
			user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
			user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
		}else if(user.getFirstName().contains(" ")) {
			user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
		}else if(user.getLastName().contains(" ")) {
			user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
		}
		
		
		users.add(user);
		userRepository.save(user);
		
	}
	
	public Iterable<User> getAllUser(){
		return userRepository.findAll();
	}
}
