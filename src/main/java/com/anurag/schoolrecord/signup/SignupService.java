package com.anurag.schoolrecord.signup;

import java.util.ArrayList;
import java.util.Optional;

import com.anurag.schoolrecord.entities.User;

public interface SignupService {
	String addUser(User user);
	ArrayList<User> getAllUser();
	Optional<User> getUser(String username);
	String removeUser(String username);
	String updateUser(User user);
}
