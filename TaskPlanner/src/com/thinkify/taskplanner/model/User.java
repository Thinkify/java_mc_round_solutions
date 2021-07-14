package com.thinkify.taskplanner.model;

import java.util.List;
public class User {
	private String name;
	private List<Task> taskList;
	private String sprint;

	public User(String name, List<Task> taskList, String sprint) {
		this.name = name;
		this.taskList = taskList;
		this.sprint = sprint;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getSprint() {
		return sprint;
	}

	public void setSprint(String sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", taskList=" + taskList + ", sprint=" + sprint + "]";
	}
	

}
