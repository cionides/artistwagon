package com.artistwagon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.UserGroup;
import com.artistwagon.web.service.GroupService;

@Controller
public class GroupController extends BaseController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value = {"/groups"}, method = RequestMethod.GET)
	public ModelAndView viewAllGroups() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/all");
		
		List<UserGroup> groups = groupService.getCurrentUsersGroups();
		model.addObject("groups", groups);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
	@RequestMapping(value = {"/groups/{userGroupId}"}, method = RequestMethod.GET)
	public ModelAndView viewSnapshot(@PathVariable int userGroupId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
	@RequestMapping(value = {"/groups/create"})
	public ModelAndView viewCreateGroup() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/new");
				
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		model.addObject("command", new Group());
		
		return model;
		
	}
	
	@RequestMapping(value = {"/groups/create/save"}, method = RequestMethod.POST)
	public ModelAndView createGroup(@ModelAttribute("command") Group group) {
		
		UserGroup userGroup = new UserGroup();
		userGroup.setBalance(0.00);
		userGroup.setGroup(group);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    userGroup.setUsername(auth.getName());
		
	    // TODO: Add Try/Catch around this service
		groupService.createGroup(userGroup);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
				
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
	@RequestMapping(value = {"/groups/{userGroupId}/members"})
	public ModelAndView viewCreateGroup(@PathVariable int userGroupId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/members");
				
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
}
