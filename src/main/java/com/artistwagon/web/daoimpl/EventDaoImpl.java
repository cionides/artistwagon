package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;

@Repository
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents() {
		
		List<Event> events = new ArrayList<Event>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Event");
		
		events = query.list();
		
		return events;
	}
	
	public void createEvent(Event event) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();	
		
		session.save(event);
		transaction.commit();
		
		session.close();	
	}
	
	public void updateEvent(Event event) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();	
		
	    session.update(event);
		transaction.commit();
		
		session.close();	
	}
	
	public Event getEventById(Integer eventId) {
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Event where id=:id")
				.setParameter("id", eventId);
		
		Event event = (Event) query.uniqueResult();
		
		return event;
	}

}
