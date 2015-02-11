package com.artistwagon.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.GroupDao;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.UserGroup;
import com.artistwagon.web.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	GroupDao groupDao;
	
	@Transactional(readOnly=true)
	public List<UserGroup> getCurrentUsersGroups() {
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
		
		return groupDao.getCurrentUsersGroups(username);
	}
	
	@Transactional(readOnly=true)
	public List<UserGroup> getUserGroupById(int id) {
		
		return groupDao.getUserGroupById(id);

	}
}