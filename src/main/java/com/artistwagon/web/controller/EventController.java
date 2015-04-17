package com.artistwagon.web.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.EventService;
import com.artistwagon.web.service.GroupService;
import com.artistwagon.web.service.UserService;

@Controller
public class EventController extends BaseController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"app/events"}, method = RequestMethod.GET)
	public ModelAndView viewAllEvents() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("events/all");
		
		setCurrentUser(model);
		
		try {
			
			List<Event> events = new ArrayList<Event>();
			events = eventService.getEvents();
			
			model.addObject("events", events);
			
		} catch(Exception e) {
			
			System.out.println("ERROR: FAILED LOADING EVENTS - " + e);
			
		};
		
		return model;
		
	}
	
	@RequestMapping(value = {"app/events/new"}, method = RequestMethod.GET)
	public ModelAndView viewCreateEvent() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("events/create");
		
		setCurrentUser(model);
		
		model.addObject("command", new Event());
		
		model.addObject("payerDropdownList", groupService.getPayers());
		model.addObject("payeeDropdownList", groupService.getPayees());
		
		return model;
		
	}
	
	@RequestMapping(value = {"app/events/save"}, method = RequestMethod.POST)
	public RedirectView createEvent(
			RedirectAttributes redirectAttributes,
			@ModelAttribute("command") Event event) {
		
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		
		try {
			
			event.setStatus("Not Paid");
			event.setPayerSlug(UUID.randomUUID().toString().replaceAll("-", ""));
			event.setPayeeSlug(UUID.randomUUID().toString().replaceAll("-", ""));
			
			eventService.createEvent(event);
			redirectAttributes.addFlashAttribute("success", "Event was successfully created.");
			
			redirectView.setUrl("/app/events");
			
		} catch (Exception e) {
						
			System.out.println("ERROR: FAILED TO SAVE EVENT - " + e);
			
			redirectView.setUrl("/app/events/new");
			
		}
		
		return redirectView;		
	}
	
	@RequestMapping(value = {"app/events/{eventId}"}, method = RequestMethod.GET)
	public ModelAndView viewEventDetails(@PathVariable(value="eventId") Integer eventId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("events/view");
		
		setCurrentUser(model);
		
		try {
			
			eventService.getEventById(eventId);
			
		} catch(Exception e) {
			
			System.out.println("ERROR: FAILED TO GET EVENT - " + e);
			
		}
		
		return model;
		
	}
	
}
