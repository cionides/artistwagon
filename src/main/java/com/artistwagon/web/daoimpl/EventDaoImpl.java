package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.Group;

@Repository
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents(Group group) {
		
		List<Event> events = new ArrayList<Event>();
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Event event left join fetch event.payees"
				+ " payees where payees.group=:group or event.payer=:group or event.owner=:group")
				.setParameter("group", group)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		events = query.list();
		
		session.close();
		
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
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Event where id=:id")
				.setParameter("id", eventId);
		
		Event event = (Event) query.uniqueResult();
		
		session.close();
		
		return event;
	}

}
