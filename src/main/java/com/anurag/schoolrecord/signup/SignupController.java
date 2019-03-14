package com.anurag.schoolrecord.signup;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.User;

@RestController
public class SignupController {
	
	@Autowired
	SignupServices signUpServices;

	@RequestMapping("/users")
	public Iterable<User> getAllUsers(){
		return signUpServices.getAllUser();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public void signup(@RequestBody User user) {
		signUpServices.addUser(user);;
	}
}
