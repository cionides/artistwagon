package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.view.model.CreateEventViewModel;

public interface EventService {
	
	public List<Event> getEvents();
	
	public void createEvent(CreateEventViewModel event);
	
	public Event getEventById(Integer eventId);
 
}
