package com.artistwagon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.User;
import com.artistwagon.web.domain.UserRole;
import com.artistwagon.web.service.UserService;

@Controller
public class SessionController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model;
 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		
	//	model.addObject("command", new Registration());
 
		return model;
 
	}
	
//	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
//	public ModelAndView createNewUser(@ModelAttribute("command") Registration registration) {
//		
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
//		String hashedPassword = passwordEncoder.encode(registration.getUser().getPassword());  
//		
//		User user = new User();
//		user.setUsername(registration.getUser().getUsername());
//		user.setPassword(hashedPassword);
//		user.setEnabled(true);
//		
//		UserRole userRole = new UserRole();
//		userRole.setUser(registration.getUser());
//
//		user.getUserRoles().add(userRole);
//
//		userService.createUser(user);
//		
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("login");
//		
//		model.addObject("msg", "Account Successfully Created! Please login to continue.");
// 
//		return model;
// 
//	}
}
