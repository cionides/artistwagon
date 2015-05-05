package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.UserDao;
import com.artistwagon.web.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	public User getUserByUserName(String username) {
 
		List<User> users = new ArrayList<User>();
 
		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
 
	}
	
	public void createUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();	
		
		session.save(user);
		transaction.commit();
		
		session.close();	
	}
	
	public void updateUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();	
		
		session.merge(user);
		transaction.commit();
		
		session.close();	
		
	}
		
}
