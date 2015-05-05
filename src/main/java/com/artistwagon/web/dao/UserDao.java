package com.artistwagon.web.dao;

import com.artistwagon.web.domain.User;

public interface UserDao {

	User getUserByUserName(String username);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
}
