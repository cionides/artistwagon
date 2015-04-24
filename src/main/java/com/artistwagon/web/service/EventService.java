package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.view.model.CreateEventViewModel;
import com.artistwagon.web.view.model.EventViewModel;

public interface EventService {
	
	public List<EventViewModel> getEvents();
	
	public void createEvent(CreateEventViewModel event);
	
	public EventViewModel getEventById(Integer eventId);
 
}
