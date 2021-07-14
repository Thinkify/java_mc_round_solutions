package com.thinkify.taskplanner.service;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.Sprint;
import com.thinkify.taskplanner.model.Task;
import com.thinkify.taskplanner.repository.SprintRepository;

public class SprintService {
	
	public String createSprint(Sprint sprint, SprintRepository sprintRepository)
	{
		sprintRepository.getSprintList().add(sprint);
		return "Sprint created";
	}
	
	public String deleteSprint(String sprintTitle, SprintRepository sprintRepository)
	{
		List<Sprint> newSprintList = new LinkedList<Sprint>();
		List<Sprint> oldSprintList = sprintRepository.getSprintList();
		for(Sprint sprint : oldSprintList)
		{
			if(sprint.getSprintTitle().equals(sprintTitle))continue;
			else
			{
				newSprintList.add(sprint);
			}
		}
		sprintRepository.setSprintList(newSprintList);
		return "Sprint Deleted";
	}
	
	public String addTaskToSprint(Task task, String sprintTitle, SprintRepository sprintRepository)
	{
		for(Sprint sprint : sprintRepository.getSprintList())
		{
			if(sprint.getSprintTitle().equals(sprintTitle))
			{
				List<Task> taskList = sprint.getTaskList();
				taskList.add(task);
				sprint.setTaskList(taskList);
			}
		}
		return "Added task to the sprint";
		
	}
	
	public String deleteTaskFromoSprint(String taskTitle, String sprintTitle, SprintRepository sprintRepository)
	{
		for(Sprint sprint : sprintRepository.getSprintList())
		{
			if(sprint.getSprintTitle().equals(sprintTitle))
			{
				List<Task> newTaskList = new LinkedList<Task>();
				List<Task> oldTaskList = sprint.getTaskList();
				for(Task task : oldTaskList)
				{
					if(task.getTitle().equals(taskTitle))continue;
					else
					{
						newTaskList.add(task);
					}
				}
				sprint.setTaskList(newTaskList);
			}
		}
		return "Deleted task from the sprint";
		
	}
	
	public Sprint displaySprint(String sprintTitle, SprintRepository sprintRepository)
	{
		for(Sprint sprint : sprintRepository.getSprintList())
		{
			if(sprint.getSprintTitle().equals(sprintTitle))return sprint;
		}
		return null;
	}

}
