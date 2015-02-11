package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.GroupDao;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.UserGroup;

@Repository
public class GroupDaoImpl implements GroupDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> getCurrentUsersGroups(String username) {
		
		List<UserGroup> userGroups = new ArrayList<UserGroup>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserGroup where username= :username ")
				.setParameter("username", username);
		
		userGroups = query.list();
		
		return userGroups;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> getUserGroupById(int id) {
		
		List<UserGroup> userGroup = new ArrayList<UserGroup>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserGroup where id=:id")
				.setParameter("id", id);
		
		userGroup = query.list();
		
		return userGroup;
	}

}
