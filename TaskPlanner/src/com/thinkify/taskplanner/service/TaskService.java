package com.thinkify.taskplanner.service;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.Task;
import com.thinkify.taskplanner.model.User;
import com.thinkify.taskplanner.repository.TaskRepository;
import com.thinkify.taskplanner.repository.UserRepository;

public class TaskService {
	public String createTask(Task task, TaskRepository taskRepository, UserRepository userRepository)
	{
		taskRepository.addTask(task);
		for(User temp: userRepository.getUserList())
		{
			if(temp.getName().equals(task.getAssignee()))
			{
				List<Task> taskList = temp.getTaskList();
				taskList.add(task);
				temp.setTaskList(taskList);
				return "Task has been added sucessfully";
			}
		}
		String name = task.getAssignee();
		List<Task> taskList = new LinkedList<Task>();
		taskList.add(task);
		String sprint = "";
		User user = new User(name,taskList,sprint);
		userRepository.addUser(user);
		return "Task has been added sucessfully";
		
	}
	
	public String changeStatus(String title, String oldStatus, TaskRepository taskRepository)
	{
		  for(Task task: taskRepository.getTaskList())
		  {
			  if(task.getTitle().equals(title))
			  {
				  task.setStatus(oldStatus);
				  return "Status has been updated";
			  }
		  }
		  return null;
	}

	public String changeAssignee(String title, String newAssignee, TaskRepository taskRepository,UserRepository userRepository) {
		for(Task task: taskRepository.getTaskList())
		  {
			  if(task.getTitle().equals(title))
			  {
				  task.setAssignee(newAssignee);
				  for(User user : userRepository.getUserList())
				  {
					  if(user.getName().equals(newAssignee))
					  {
						  List<Task> taskList = user.getTaskList();
						  taskList.add(task);
					  }
				  }
				  return "Assignee has been updated";
			  }
		  }
		  return null;
	}
}
