package com.bms.service;

import com.bms.domain.User;
import com.bms.domain.UserRoles;

public interface UserService {
	
	public User getUser();

	public void addUser(User user,UserRoles userRoles);
	
	public void updatePassword(String username, String password);

}
