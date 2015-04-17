package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Event;

public interface EventDao {
	
	public List<Event> getEvents();
	
	public void createEvent(Event event);
	
	public Event getEventById(Integer eventId);
	
}
