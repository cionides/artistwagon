package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.UserGroup;

public interface GroupService {
	
	public void createGroup(UserGroup userGroup);
	 
	public List<UserGroup> getCurrentUsersGroups();

	public List<UserGroup> getUserGroupById(int id);
 
}
