package com.thinkify.taskplanner.repository;

import java.util.LinkedList;
import java.util.List;

import com.thinkify.taskplanner.model.Sprint;

public class SprintRepository {
	private List<Sprint> sprintList;

	public SprintRepository()
	{
		sprintList = new LinkedList<Sprint>();
	}
	public List<Sprint> getSprintList() {
		return sprintList;
	}

	public void setSprintList(List<Sprint> sprintList) {
		this.sprintList = sprintList;
	}
	@Override
	public String toString() {
		return "SprintRepository [sprintList=" + sprintList + "]";
	}
	
}
