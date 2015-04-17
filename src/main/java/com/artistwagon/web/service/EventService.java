package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Event;

public interface EventService {
	
	public List<Event> getEvents();
	
	public void createEvent(Event event);
	
	public Event getEventById(Integer eventId);
 
}
