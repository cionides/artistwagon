package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Group;

public interface GroupService {
	
	public List<Group> getPayers();
	
	public List<Group> getPayees();
 
}
