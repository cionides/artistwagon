package com.artistwagon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.UserGroup;
import com.artistwagon.web.service.GroupService;
import com.artistwagon.web.service.UserService;

@Controller
public class BandController extends BaseController {
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
	
//	@RequestMapping(value = {"bank/bands"}, method = RequestMethod.GET)
//	public ModelAndView viewAllGroups() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("group/all");
//		
//		List<userBand> userBands = groupService.getCurrentUsersGroups();
//		model.addObject("userBands", userBands);
//		
//		return model;
//		
//	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}"}, method = RequestMethod.GET)
	public ModelAndView viewSnapshot(@PathVariable int userBandId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		
		List<UserGroup> userBand = groupService.getUserGroupById(userBandId);
		model.addObject("userBand", userBand);
		
		return model;
		
	}
	
//	@RequestMapping(value = {"bank/bands/create"})
//	public ModelAndView viewCreateGroup() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("group/new");
//		
//		model.addObject("command", new Group());
//		
//		return model;
//		
//	}
//	
//	@RequestMapping(value = {"bank/bands/create/save"}, method = RequestMethod.POST)
//	public ModelAndView createGroup(@ModelAttribute("command") Group group) {
//		
//		userBand userBand = new userBand();
//		userBand.setBalance(0.00);
//		userBand.setGroup(group);
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    userBand.setUser(userService.getUserByUsername(auth.getName()));
//		
//	    // TODO: Add Try/Catch around this service
//		groupService.createGroup(userBand);
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("group/snapshot");
//		
//		return model;
//		
//	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}/members"})
	public ModelAndView viewCreateGroup(@PathVariable int userBandId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("band/members");
		
		List<UserGroup> userBand = groupService.getUserGroupById(userBandId);
		model.addObject("userBand", userBand);
		
		List<UserGroup> groupMembers = groupService.getGroupMembers(userBand.get(0).getGroup().getId());
		model.addObject("groupMembers", groupMembers);
		
		return model;
		
	}
	
}
