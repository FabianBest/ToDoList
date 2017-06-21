package com.java.korki.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class TasksHandler {
	List<Tasks> tasksList = new ArrayList<>();
	Map<Users, Tasks> userTaskMap = new HashMap<>();
	
	public void creatingTasks(String name, String day, String month, String year){
		Tasks task = new Tasks(name, day, month, year);
		tasksList.add(task);
	}
	
	public Tasks searchingTasks(String name) {
		int tempSearch = -1;
		for(int i = 0; i < tasksList.size(); i++) {
			if(tasksList.get(i).getName().equals(name)){
				tempSearch = i;
			} 
		}
			return tasksList.get(tempSearch);
	}
	
	public void addingUserToTask(String name, Users user) {
		try {
			userTaskMap.put(user, searchingTasks(name));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nie ma takiego tasku");
		}
	}
	
	public void deletingTask(String name){
		for (int i = 0; i < tasksList.size(); i++) {
			if (tasksList.get(i).getName().equals(name)) {
				tasksList.remove(i);
			}
		}
	}
	
	public void sortTasks(String day, Users user){
		userTaskMap.get(user).compareTo(day);
	}

	public List<Tasks> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Tasks> tasksList) {
		this.tasksList = tasksList;
	}

	public Map<Users, Tasks> getUserTaskMap() {
		return userTaskMap;
	}

	public void setUserTaskMap(Map<Users, Tasks> userTaskMap) {
		this.userTaskMap = userTaskMap;
	}
	
}
