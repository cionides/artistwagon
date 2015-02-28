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
//		List<UserGroup> userGroups = groupService.getCurrentUsersGroups();
//		model.addObject("userGroups", userGroups);
//		
//		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
//		
//		return model;
//		
//	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}"}, method = RequestMethod.GET)
	public ModelAndView viewSnapshot(@PathVariable int userGroupId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
//	@RequestMapping(value = {"bank/bands/create"})
//	public ModelAndView viewCreateGroup() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("group/new");
//				
//		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
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
//		UserGroup userGroup = new UserGroup();
//		userGroup.setBalance(0.00);
//		userGroup.setGroup(group);
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    userGroup.setUser(userService.getUserByUsername(auth.getName()));
//		
//	    // TODO: Add Try/Catch around this service
//		groupService.createGroup(userGroup);
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("group/snapshot");
//				
//		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
//		
//		return model;
//		
//	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}/members"})
	public ModelAndView viewCreateGroup(@PathVariable int userGroupId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("band/members");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		List<UserGroup> groupMembers = groupService.getGroupMembers(userGroup.get(0).getGroup().getId());
		model.addObject("groupMembers", groupMembers);
				
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
}
