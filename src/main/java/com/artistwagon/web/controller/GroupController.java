package com.artistwagon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = {"/groups/{groupId}"}, method = RequestMethod.GET)
	public ModelAndView viewSnapshot(@PathVariable int groupId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(groupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
		
	}
	
}
