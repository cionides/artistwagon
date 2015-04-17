package com.artistwagon.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.service.EventService;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDao eventDao;
	
	@Transactional(readOnly=true)
	public List<Event> getEvents() {
		
		return eventDao.getEvents();
	}
	
	@Transactional
	public void createEvent(Event event) {
		
		eventDao.createEvent(event);
	}

	@Transactional(readOnly=true)
	public Event getEventById(Integer eventId) {
		
		return eventDao.getEventById(eventId);
	}

}