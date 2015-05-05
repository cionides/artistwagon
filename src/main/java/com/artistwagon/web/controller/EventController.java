package com.artistwagon.web.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.artistwagon.web.domain.Event;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.EventService;
import com.artistwagon.web.service.GroupService;
import com.artistwagon.web.service.TransactionService;
import com.artistwagon.web.service.UserService;
import com.artistwagon.web.view.model.CreateEventViewModel;
import com.artistwagon.web.view.model.EventViewModel;

@Controller
public class EventController extends BaseController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = {"app/events"}, method = RequestMethod.GET)
	public ModelAndView viewAllEvents() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("events/all");
		
		setCurrentUser(model);
		
		//Object consumerKey = session.getAttribute("synapseConsumerKey");
		
		try {
			
			List<EventViewModel> events = new ArrayList<EventViewModel>();
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
		
		model.addObject("command", new CreateEventViewModel());
		
		model.addObject("payerDropdownList", groupService.getPayers());
		model.addObject("payeesDropdownList", groupService.getPayees());
		
		return model;
		
	}
	
	@RequestMapping(value = {"app/events/save"}, method = RequestMethod.POST)
	public RedirectView createEvent(
			RedirectAttributes redirectAttributes,
			@ModelAttribute("command") CreateEventViewModel event) {
		
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		
		try {
			
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
	public ModelAndView viewEventDetails(
			@PathVariable(value="eventId") Integer eventId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("events/view");
		
		setCurrentUser(model);
		
		try {
			
			EventViewModel event = eventService.getEventById(eventId);
			
			model.addObject("event", event);
			
		} catch(Exception e) {
			
			System.out.println("ERROR: FAILED TO GET EVENT - " + e);
			
		}
		
		return model;
		
	}
	
	@RequestMapping(value = {"app/events/{eventId}/makePayment"}, method = RequestMethod.GET)
	public RedirectView makePayment(
			@PathVariable(value="eventId") Integer eventId,
			RedirectAttributes redirectAttributes) {
	
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		
		try {
			
			transactionService.makePayment(eventId);
			redirectAttributes.addFlashAttribute("success", "Payment was successful.");
			
			redirectView.setUrl("/app/events");
			
		} catch (Exception e) {
						
			System.out.println("ERROR: FAILED TO MAKE PAYMENT - " + e);
			
			redirectView.setUrl("/app/events/new");
			
		}
		
		return redirectView;
		
	}
	
}
