package com.java.korki.main;

import java.util.Date;

import com.java.korki.actions.ProjectsHandler;
import com.java.korki.actions.TasksHandler;
import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class Main {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		Tasks task = new Tasks("test","01","01","1999");
		System.out.println(task);
		
		Users user1 = new Users("a","a","a","a");
		ProjectsHandler projHand = new ProjectsHandler();
		TasksHandler taskHand = new TasksHandler();
		projHand.creatingProjects("test");
		projHand.addingUserToProject("test", user1);
		taskHand.creatingTasks("testing", "11", "11", "1999");
		taskHand.addingUserToTask("testing", user1);
	}

}
