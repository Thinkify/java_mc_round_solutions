package com.thinkify.taskplanner.driver;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.Sprint;
import com.thinkify.taskplanner.model.Task;
import com.thinkify.taskplanner.model.User;
import com.thinkify.taskplanner.repository.SprintRepository;
import com.thinkify.taskplanner.repository.TaskRepository;
import com.thinkify.taskplanner.repository.UserRepository;
import com.thinkify.taskplanner.service.SprintService;
import com.thinkify.taskplanner.service.TaskService;
import com.thinkify.taskplanner.service.UserService;

public class Launch {
	public static void main(String[] args) {
		TaskRepository taskRepository = new TaskRepository();
		SprintRepository sprintRepository = new SprintRepository();
		UserRepository userRepository = new UserRepository();
		TaskService taskService = new TaskService();
		UserService userService = new UserService();
		SprintService sprintService = new SprintService();
		Task task1 = new Task("title","creater", "pawankumar" ,"status","type","duedate");
		taskService.createTask(task1,taskRepository,userRepository);
		Task task2 = new Task("title1","creater2", "Assignee3" ,"status4","type5","duedate6");
		taskService.createTask(task2,taskRepository,userRepository);
		System.out.println(taskRepository.getTaskList());
		System.out.println(taskService.changeStatus("title1", "updatedstatus", taskRepository));
        System.out.println(taskRepository.getTaskList());
        System.out.println(taskService.changeAssignee("title1", "pawankumar", taskRepository, userRepository));
        System.out.println(taskRepository.getTaskList());
        System.out.println(userService.displayUserStatus("pawankumar",userRepository));
        List<Task> taskList = new LinkedList<Task>();
        taskList.add(task1);
        taskList.add(task2);
        Sprint sprint1 = new Sprint("Sprint-1",taskList);
        System.out.println(sprintService.createSprint(sprint1, sprintRepository));
        System.out.println(sprintService.displaySprint("Sprint-1", sprintRepository));
        Sprint sprint2 = new Sprint("Sprint-2",taskList);
        System.out.println(sprintService.createSprint(sprint2, sprintRepository));
        System.out.println(sprintService.displaySprint("Sprint-2", sprintRepository));
        System.out.println(sprintRepository);
        System.out.println(sprintService.deleteSprint("Sprint-2", sprintRepository));
        System.out.println(sprintRepository);
        Task task3 = new Task("title100","creater200", "Assignee300" ,"status400","type500","duedate6");
		taskService.createTask(task3,taskRepository,userRepository);
		System.out.println(sprintService.addTaskToSprint(task3, "Sprint-1", sprintRepository));
		System.out.println(sprintRepository);
		System.out.println(sprintService.deleteTaskFromoSprint("title100", "Sprint-1", sprintRepository));
		System.out.println(sprintRepository);
	}

}
