package com.anurag.schoolrecord.signup;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.User;

@Service
public class SignupServices {
	@Autowired
	private UserRepository userRepository;
	
	
	//Add users
	public void addUser(User user) {
		//first_name and last_name validations
		if(user.getFirstName().contains(" ") && user.getLastName().contains(" ")) {
			user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
			user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
		}else if(user.getFirstName().contains(" ")) {
			user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
		}else if(user.getLastName().contains(" ")) {
			user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
		}
		
		
		userRepository.save(user);
		
	}
	
	//Show all the users
	public ArrayList<User> getAllUser(){
		ArrayList<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	//To search a user.
	public Optional<User> getUser(String username) {
		return userRepository.findById(username);
	}
	
	
	//Remove a user
	public void removeUser(String username) {
		userRepository.deleteById(username);
	}
	
	//Update users
		public void updateUser(User user) {
			//first_name and last_name validations
			if(user.getFirstName().contains(" ") && user.getLastName().contains(" ")) {
				user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
				user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
			}else if(user.getFirstName().contains(" ")) {
				user.setFirstName(user.getFirstName().substring(0,user.getFirstName().indexOf(' ')));
			}else if(user.getLastName().contains(" ")) {
				user.setLastName(user.getLastName().substring(0,user.getLastName().indexOf(' ')));
			}
			
			
			userRepository.save(user);
			
		}
}
