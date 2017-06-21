package com.java.korki.main;

import java.util.Calendar;
import java.util.Date;

import com.java.korki.actions.ProjectsHandler;
import com.java.korki.actions.TasksHandler;
import com.java.korki.actions.UserHandler;
import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class Main {

	public static void testPrint(){
		for(Users temp: UserHandler.getInstance().getUsersList()) {
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		int data = Calendar.DAY_OF_MONTH;
		
		System.out.println(data);
		
		UserHandler.getInstance().creatingUser("a", "a", "a", "a");
		ProjectsHandler.getInstance().creatingProjects("test");
		ProjectsHandler.getInstance().addingUserToProject("test", UserHandler.getInstance().getUsersList().get(0));
		TasksHandler.getInstance().creatingTasks("testing", "04", "12", "1999");
		TasksHandler.getInstance().creatingTasks("testing2", "21", "11", "1999");
		TasksHandler.getInstance().creatingTasks("testing3", "05", "11", "1999");
		TasksHandler.getInstance().creatingTasks("testing4", "01", "12", "1999");
		TasksHandler.getInstance().addingUserToTask("a", "testing");
		TasksHandler.getInstance().addingUserToTask("a", "testing4");
		TasksHandler.getInstance().addingUserToTask("a", "testing2");
		TasksHandler.getInstance().addingUserToTask("a", "testing3");
		TasksHandler.getInstance().sortTasks("a");
		TasksHandler.getInstance().deletingTask("testing4");
		TasksHandler.getInstance().searchingTaskByDay("a", "21");
		TasksHandler.getInstance().setTaskDescription("a", "testing", "To jest testowy opis");
		TasksHandler.getInstance().searchingTaskByDay("a", "04");
		testPrint();

	
	}

}
