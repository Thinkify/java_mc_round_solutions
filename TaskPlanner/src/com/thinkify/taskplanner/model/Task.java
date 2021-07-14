package com.thinkify.taskplanner.model;
import java.util.*;

import com.thinkify.taskplanner.repository.TaskRepository;
import com.thinkify.taskplanner.service.TaskService;  

public class Task {
	private String creater;
	private String assignee;
	private String status;
	private String type;
	private String dueDate;
	private String title;
	
	public Task() {
	  //taskRepository = new TaskRepository();
	}
	
	public Task(String title, String creator, String assignee, String status, String type, String dueDate) {
		this.title = title;
		this.creater = creator;
		this.assignee = assignee;
		this.status = status;
		this.type = type;
		this.dueDate = dueDate;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	@Override
	public String toString() {
		return "Task [creater=" + creater + ", assignee=" + assignee + ", status=" + status + ", type=" + type
				+ ", dueDate=" + dueDate + ", title=" + title + "]";
	}
	

}
