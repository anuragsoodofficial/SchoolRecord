package com.anurag.schoolrecord.signup;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.User;

@RestController
public class SignupController {
	
	@Autowired
	SignupServicesImpl signUpServices;

	//showing all users
	@GetMapping("/users")
	public Iterable<User> getAllUsers(){
		return signUpServices.getAllUser();
	}
	
	//adding the user
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		signUpServices.addUser(user);
		return "Success";
	}
	
	
	//getting a user by its username
	@GetMapping("/student/get")
	public Optional<User> getUser(@RequestParam(name = "username",defaultValue="Unknown") String username) {
		return signUpServices.getUser(username);
	}
	
	@DeleteMapping("/users")
	public String removeUser(@RequestParam(name = "username",defaultValue="Unknown") String username) {
		signUpServices.removeUser(username);
		return "Removed Successfully";
	}
	
	//update the user
		@PutMapping("/signup")
		public String updateUser(@RequestBody User user) {
			signUpServices.updateUser(user);
			return "Updated Successfully";
		}
}
