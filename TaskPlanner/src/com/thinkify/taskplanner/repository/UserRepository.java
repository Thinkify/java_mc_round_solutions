package com.thinkify.taskplanner.repository;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.User;

public class UserRepository {
	private List<User> userList;
	
	public UserRepository()
	{
		userList = new LinkedList<User>();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public void addUser(User user)
	{
		userList.add(user);
	}
	public User getUser(String name)
	{
		for(User temp : userList)
		{
			if(temp.getName().equals(name))return temp;
		}
		return null;
	}
	
}
