package com.thinkify.taskplanner.service;

import com.thinkify.taskplanner.model.User;
import com.thinkify.taskplanner.repository.UserRepository;

public class UserService {

	public User displayUserStatus(String name, UserRepository userRepository) {
		for(User user : userRepository.getUserList())
		{
			if(user.getName().equals(name))
				return user;
		}
		return null;
	
		
	}

}
