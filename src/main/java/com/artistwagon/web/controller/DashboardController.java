package com.artistwagon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.service.GroupService;

@Controller
public class DashboardController extends BaseController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value = {"/app"}, method = RequestMethod.GET)
	public ModelAndView index() {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
				
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
}
