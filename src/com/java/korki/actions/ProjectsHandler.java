package com.java.korki.actions;

import java.util.ArrayList;
import java.util.List;

import com.java.korki.datamodel.Projects;
import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class ProjectsHandler {

	List<Projects> projectsList = new ArrayList<>();

	public void creatingProjects(String name) {
		Projects project = new Projects(name);
		projectsList.add(project);
	}

	public Projects searchingProjects(String name) {
		int tempSearch = -1;
		for (int i = 0; i < projectsList.size(); i++) {
			if (projectsList.get(i).getName().equals(name)) {
				tempSearch = i;
			}
		}
		return projectsList.get(tempSearch);
	}

	public void addingUserToProject(String name, Users user) {
		try {
			searchingProjects(name).getUsersList().add(user);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nie ma takiego projektu");
		}
	}

	public void addingTaskToProject(Tasks task, String name) {
		try {
			searchingProjects(name).getTasksList().add(task);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nie ma takiego projektu");
		}
	}

	public void deletingProject(String name) {
		for (int i = 0; i < projectsList.size(); i++) {
			if (projectsList.get(i).getName().equals(name)) {
				projectsList.remove(i);
			}
		}
	}

	public List<Projects> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Projects> projectsList) {
		this.projectsList = projectsList;
	}

}
