package com.thinkify.taskplanner.model;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.repository.SprintRepository;

public class Sprint {
	private String sprintTitle;
	private List<Task> taskList;

	public Sprint() {
	}

	public Sprint(String sprintTitle, List<Task> taskList) {
		this.sprintTitle = sprintTitle;
		this.taskList = taskList;
	}
	
	public String getSprintTitle() {
		return sprintTitle;
	}

	public void setSprintTitle(String sprintTitle) {
		this.sprintTitle = sprintTitle;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> task) {
		this.taskList = task;
	}

	@Override
	public String toString() {
		return "Sprint [sprintTitle=" + sprintTitle + ", taskList=" + taskList + "]";
	}

}
