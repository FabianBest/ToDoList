package com.java.korki.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Projects {
	private String name;
	private List<Tasks> tasksList = new ArrayList<>();
	private List<Users> usersList = new ArrayList<>();

	public Projects(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tasks> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Tasks> tasksList) {
		this.tasksList = tasksList;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
}
