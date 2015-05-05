package com.artistwagon.web.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.UserDao;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Transactional(readOnly=true)
	public User getUserByUsername(String username) {
		
		return userDao.getUserByUserName(username);
		
	}
	
	@Transactional
	public void createUser(User user) {
		
		userDao.createUser(user);
		
	}
		
	@Transactional
	public void updateUser(User user) {
		
		userDao.updateUser(user);
		
	}
}
