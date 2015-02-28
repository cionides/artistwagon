package com.artistwagon.web.dao;

import com.artistwagon.web.domain.User;

public interface UserDao {

	User getUserByUserName(String username);
	
}
