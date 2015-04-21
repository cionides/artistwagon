package com.artistwagon.web.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.EventPayee;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.service.EventService;
import com.artistwagon.web.view.model.CreateEventViewModel;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDao eventDao;
	
	@Transactional(readOnly=true)
	public List<Event> getEvents() {
		
		return eventDao.getEvents();
	}
	
	@Transactional
	public void createEvent(CreateEventViewModel event) {
		
		Event newEvent = new Event();
		newEvent.setDate(event.getDate());
		newEvent.setPrice(event.getPrice());
		
		String payeeString = event.getPayees().get(0);
		List<String> payeeList = Arrays.asList(payeeString.split(","));
		
		List<EventPayee> payees = new ArrayList<EventPayee>();
		
		for (String string :  payeeList) {
			EventPayee eventPayee = new EventPayee();
			eventPayee.setEvent(newEvent);
			
			Group group = new Group();
			group.setId(Integer.parseInt(string));
			eventPayee.setGroup(group);
			
			payees.add(eventPayee);
		}
		
		newEvent.setPayees(payees);
		
		newEvent.setStatus("Not Paid");
		
		Group payer = new Group();
		payer.setId(event.getPayer());
		
		newEvent.setPayer(payer);
		
		eventDao.createEvent(newEvent);
	}

	@Transactional(readOnly=true)
	public Event getEventById(Integer eventId) {
		
		return eventDao.getEventById(eventId);
	}

}