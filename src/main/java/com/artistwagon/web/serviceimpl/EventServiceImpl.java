package com.artistwagon.web.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.EventPayee;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.EventService;
import com.artistwagon.web.service.UserService;
import com.artistwagon.web.view.model.CreateEventViewModel;
import com.artistwagon.web.view.model.EventPayeeViewModel;
import com.artistwagon.web.view.model.EventViewModel;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDao eventDao;
	
	@Autowired
	UserService userService;
	
	@Transactional(readOnly=true)
	public List<EventViewModel> getEvents() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.getUserByUsername(auth.getName());
		
		List<Event> events = eventDao.getEvents(currentUser.getGroup());
		List<EventViewModel> eventViewModels = new ArrayList<EventViewModel>();
		
		for(Event event : events) {
			EventViewModel eventViewModel = new EventViewModel();
			eventViewModel.setId(event.getId());
			eventViewModel.setDate(event.getDate());
			eventViewModel.setOwner(event.getOwner());
			eventViewModel.setPayees(event.getPayees());
			eventViewModel.setPayer(event.getPayer());
			eventViewModel.setStatus(event.getStatus());
			eventViewModel.setAgencyFee(event.getAgencyFee());
			
			eventViewModels.add(eventViewModel);
			
		}
		
		return eventViewModels;
	}
	
	@Transactional
	public void createEvent(CreateEventViewModel event) {
		
		Event newEvent = new Event();
		newEvent.setDate(event.getDate());
		
		if(event.getAgencyFee() == null) {
			Double agencyFee = 0.0;
			newEvent.setAgencyFee(agencyFee);
		} else {
			newEvent.setAgencyFee(event.getAgencyFee());
		}
		
		List<EventPayee> payees = new ArrayList<EventPayee>();
		
		for (EventPayeeViewModel payee :  event.getPayees()) {
			EventPayee eventPayee = new EventPayee();
			eventPayee.setEvent(newEvent);
			
			Group group = new Group();
			group.setId(Integer.parseInt(payee.getGroupId()));
			eventPayee.setGroup(group);
			
			eventPayee.setAmount(Double.parseDouble(payee.getCost()));
			
			payees.add(eventPayee);
		}
		
		newEvent.setPayees(payees);
		
		newEvent.setStatus("Not Paid");
		
		Group payer = new Group();
		payer.setId(event.getPayer());
		
		newEvent.setPayer(payer);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.getUserByUsername(auth.getName());
		
		newEvent.setOwner(currentUser.getGroup());
		
		eventDao.createEvent(newEvent);
	}

	@Transactional(readOnly=true)
	public EventViewModel getEventById(Integer eventId) {
		
		Event event = eventDao.getEventById(eventId);
		
		EventViewModel eventViewModel = new EventViewModel();
		
		eventViewModel.setId(event.getId());
		eventViewModel.setDate(event.getDate());
		eventViewModel.setOwner(event.getOwner());
		eventViewModel.setPayees(event.getPayees());
		eventViewModel.setPayer(event.getPayer());
		eventViewModel.setStatus(event.getStatus());
		eventViewModel.setAgencyFee(event.getAgencyFee());
		
		return eventViewModel;
	}

}