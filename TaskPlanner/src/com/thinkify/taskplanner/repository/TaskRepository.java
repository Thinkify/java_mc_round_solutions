package com.thinkify.taskplanner.repository;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.Task;

public class TaskRepository {
	private List<Task> taskList;
	
    public TaskRepository()
    {
    	taskList = new LinkedList<Task>();
    }
	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	public void addTask(Task task)
	{
		taskList.add(task);
	}
	public Task getTask(String title)
	{
		for(Task temp : taskList)
		{
			if(temp.getTitle().equals(title))return temp;
		}
		return null;
		
	}
}
