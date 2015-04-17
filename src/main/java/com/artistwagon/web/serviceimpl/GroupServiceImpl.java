package com.artistwagon.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.dao.GroupDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.service.EventService;
import com.artistwagon.web.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	GroupDao groupDao;
	
	@Transactional(readOnly=true)
	public List<Group> getPayers() {
		
		return groupDao.getPayers();
	}
	
	@Transactional(readOnly=true)
	public List<Group> getPayees() {
		
		return groupDao.getPayees();
	}

}