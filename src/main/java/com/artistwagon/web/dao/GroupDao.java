package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.UserGroup;

public interface GroupDao {
	
	public void createGroup(UserGroup userGroup);
	
	public List<UserGroup> getCurrentUsersGroups(String username);
	
	public List<UserGroup> getUserGroupById(int id);
	
}