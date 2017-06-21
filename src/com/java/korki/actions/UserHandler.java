package com.java.korki.actions;

import java.util.ArrayList;
import java.util.List;

import com.java.korki.datamodel.Users;

public class UserHandler {
	List<Users> usersList = new ArrayList<>();
	
	public void creatingUser(String name, String surname, String login, String password) {
		Users user = new Users(name, surname, login, password);
		usersList.add(user);
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	
	
	
}
