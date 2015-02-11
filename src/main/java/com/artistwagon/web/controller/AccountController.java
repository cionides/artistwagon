package com.artistwagon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.service.GroupService;

@Controller
public class AccountController extends BaseController {
	
	@Autowired
	GroupService groupService;

	@RequestMapping(value = {"/accounts/new"}, method = RequestMethod.GET)
	@ResponseBody public ModelAndView newAccount() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("account/new");
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
	}
}
