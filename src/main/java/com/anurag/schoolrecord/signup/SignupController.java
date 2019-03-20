package com.anurag.schoolrecord.signup;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.User;

@RestController
public class SignupController {
	
	@Autowired
	SignupServicesImpl signUpServices;

	//showing all users
	@RequestMapping("/users")
	public Iterable<User> getAllUsers(){
		return signUpServices.getAllUser();
	}
	
	//adding the user
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public String signup(@RequestBody User user) {
		signUpServices.addUser(user);
		return "Success";
	}
	
	
	//getting a user by its username
	@RequestMapping("users?username=")
	public Optional<User> getUser(@PathVariable String username) {
		return signUpServices.getUser(username);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users?username=")
	public String removeUser(@PathVariable String username) {
		signUpServices.removeUser(username);
		return "Removed Successfully";
	}
	
	//update the user
		@RequestMapping(method=RequestMethod.PUT,value="/signup")
		public String updateUser(@RequestBody User user) {
			signUpServices.updateUser(user);
			return "Updated Successfully";
		}
}
