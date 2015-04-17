package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.Group;

public interface GroupDao {
	
	public List<Group> getPayers();
	
	public List<Group> getPayees();
}
