package com.artistwagon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	UserService userService;
	
	public void setCurrentUser(ModelAndView model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.getUserByUsername(auth.getName());
		
		model.addObject("currentUser", currentUser);

	}

}
