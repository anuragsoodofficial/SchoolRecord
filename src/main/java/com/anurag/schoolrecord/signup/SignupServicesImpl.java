package com.anurag.schoolrecord.signup;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.entities.User;

@Service
public class SignupServicesImpl implements SignupService {
	@Autowired
	private UserRepository userRepository;

		@Override
		public String addUser(User user) {
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
			return "Added";
		}

		@Override
		public ArrayList<User> getAllUser() {
			ArrayList<User> users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			return users;
		}

		@Override
		public Optional<User> getUser(String username) {
			return userRepository.findById(username);
		}

		@Override
		public String removeUser(String username) {
			userRepository.deleteById(username);
			return "Removed";
		}

		@Override
		public String updateUser(User user) {
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
			return "Updated";
		}
}
