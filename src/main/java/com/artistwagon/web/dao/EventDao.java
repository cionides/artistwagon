package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.Group;

public interface EventDao {
	
	public List<Event> getEvents(Group group);
	
	public void createEvent(Event event);
	
	public Event getEventById(Integer eventId);
	
	public void updateEvent(Event event);
	
}
