package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.BandDao;
import com.artistwagon.web.domain.Band;
import com.artistwagon.web.domain.UserBand;

@Repository
public class BandDaoImpl implements BandDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void createBand(UserBand userBand) {
		
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();	
			
			session.save(userBand);
			transaction.commit();
			
			session.close();	
	}
	
	@SuppressWarnings("unchecked")
	public List<UserBand> getCurrentUsersBands(String username) {
		
		List<UserBand> userBands = new ArrayList<UserBand>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserBand where username= :username ")
				.setParameter("username", username);
		
		userBands = query.list();
		
		return userBands;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserBand> getUserBandById(int id) {
		
		List<UserBand> userBand = new ArrayList<UserBand>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserBand where id=:id")
				.setParameter("id", id);
		
		userBand = query.list();
		
		return userBand;
	}

	@SuppressWarnings("unchecked")
	public List<UserBand> getBandMembers(int bandId) {
		
		List<UserBand> bandMembers = new ArrayList<UserBand>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserBand where group_id=:groupId")
				.setParameter("groupId", bandId);
		
		bandMembers = query.list();
		
		return bandMembers;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserBand> getActiveBand(String username) {
		
		List<UserBand> activeBand = new ArrayList<UserBand>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From UserBand where username=:username AND isActive=1")
				.setParameter("username", username);
		
		activeBand = query.list();
		
		return activeBand;
	}

}
