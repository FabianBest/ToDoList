package com.java.korki.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class TasksHandler {
	
	private static TasksHandler taskHandler;
	
	List<Tasks> tasksList = new ArrayList<>();
	
	
	public static TasksHandler getInstance() {
		if(taskHandler == null) {
			taskHandler = new TasksHandler();
		}
		return taskHandler;
	}
	
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
	
	public void addingUserToTask(String loginUser, String nameTask) {
		try {
			UserHandler.getInstance().searchingUser(loginUser).getTasksList().add(searchingTasks(nameTask));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nie ma takiego tasku, nie mo¿na przypisaæ do usera");
		}
	}
	
	public void deletingTask(String nameTask){
		for (int i = 0; i < tasksList.size(); i++) {
			if (tasksList.get(i).getName().equals(nameTask)) {
				tasksList.remove(i);
			}
		}
		
		for(int j = 0; j < UserHandler.getInstance().getUsersList().size() ; j++){
			for(int i = 0; i < UserHandler.getInstance().getUsersList().get(j).getTasksList().size(); i++){
				if(UserHandler.getInstance().getUsersList().get(j).getTasksList().get(i).getName().equals(nameTask)){
					UserHandler.getInstance().getUsersList().get(j).getTasksList().remove(i);
				}
			}
		}	
	}
	
	public void deletingTaskFromUser(String loginUser, String nameTask){
		for (int i = 0; i < UserHandler.getInstance().searchingUser(loginUser).getTasksList().size(); i++) {
			if (UserHandler.getInstance().searchingUser(loginUser).getTasksList().get(i).getName().equals(nameTask)) {
				UserHandler.getInstance().searchingUser(loginUser).getTasksList().remove(i);
			}
		}
		
	}
	
	public void sortTasks(String name){
		Collections.sort(UserHandler.getInstance().searchingUser(name).getTasksList());
	}
	
	public void searchingTaskByDay(String loginUser, String day) {
		int tempSearch = -1;
		for(int i = 0; i < UserHandler.getInstance().searchingUser(loginUser).getTasksList().size(); i++) {
			if(UserHandler.getInstance().searchingUser(loginUser).getTasksList().get(i).getDay().equals(day)){
				System.out.println(UserHandler.getInstance().searchingUser(loginUser).getTasksList().get(i));
			} 
		}
	}
	
	public void setTaskDescription(String loginUser, String nameTask, String description){
		for (int i = 0; i < UserHandler.getInstance().searchingUser(loginUser).getTasksList().size(); i++) {
			if (UserHandler.getInstance().searchingUser(loginUser).getTasksList().get(i).getName().equals(nameTask)) {
				UserHandler.getInstance().searchingUser(loginUser).getTasksList().get(i).setDescription(description);
			}
		}
	}

	public List<Tasks> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Tasks> tasksList) {
		this.tasksList = tasksList;
	}
	
}
