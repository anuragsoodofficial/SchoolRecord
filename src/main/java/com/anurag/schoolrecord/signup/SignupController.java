package com.anurag.schoolrecord.signup;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.User;

@RestController
public class SignupController {
	
	@Autowired
	SignupServices signUpServices;

	//showing all users
	@RequestMapping("/users")
	public Iterable<User> getAllUsers(){
		return signUpServices.getAllUser();
	}
	
	//adding the user
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public void signup(@RequestBody User user) {
		signUpServices.addUser(user);;
	}
	
	
	//getting a user by its username
	@RequestMapping("users/{username}")
	public Optional<User> getUser(@PathVariable String username) {
		return signUpServices.getUser(username);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{username}")
	public void removeUser(@PathVariable String username) {
		signUpServices.removeUser(username);
	}
}
