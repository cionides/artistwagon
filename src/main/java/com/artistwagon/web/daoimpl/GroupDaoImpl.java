package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.GroupDao;
import com.artistwagon.web.domain.Group;

@Repository
public class GroupDaoImpl implements GroupDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Group> getPayers() {
		
		List<Group> groups = new ArrayList<Group>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Group Where Type='Venue' OR Type='Promoter'");
		
		groups = query.list();
		
		return groups;
	}
	
	@SuppressWarnings("unchecked")
	public List<Group> getPayees() {
		
		List<Group> groups = new ArrayList<Group>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Group Where Type='Artist'");
		
		groups = query.list();
		
		return groups;
	}

}
