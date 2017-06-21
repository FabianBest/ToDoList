package com.java.korki.actions;

import java.util.ArrayList;
import java.util.List;

import com.java.korki.datamodel.Tasks;
import com.java.korki.datamodel.Users;

public class UserHandler {
	
	private static UserHandler userHandler;
	
	List<Users> usersList = new ArrayList<>();
	
	public static UserHandler getInstance(){
		if(userHandler == null){
			userHandler = new UserHandler();
		}
		return userHandler;
	}
	
	public void creatingUser(String name, String surname, String login, String password) {
		Users user = new Users(name, surname, login, password);
		usersList.add(user);
	}

	public Users searchingUser(String name) {
		int tempSearch = -1;
		for(int i = 0; i < usersList.size(); i++) {
			if(usersList.get(i).getLogin().equals(name)){
				tempSearch = i;
			} 
		}
			return usersList.get(tempSearch);
	}
	
	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	
	
	
}
