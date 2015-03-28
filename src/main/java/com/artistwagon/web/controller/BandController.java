package com.artistwagon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.UserBand;
import com.artistwagon.web.service.BandService;
import com.artistwagon.web.service.UserService;

@Controller
public class BandController extends BaseController {
	
	@Autowired
	BandService bandService;
	
	@Autowired
	UserService userService;
		
	@RequestMapping(value = {"bank/bands/{userBandId}"}, method = RequestMethod.GET)
	public ModelAndView viewSnapshot(@PathVariable int userBandId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
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
	public ModelAndView viewBandMembers(@PathVariable int userBandId) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("band/members");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
		model.addObject("userBand", userBand);
		
		List<UserBand> bandMembers = bandService.getBandMembers(userBand.get(0).getBand().getId());
		model.addObject("bandMembers", bandMembers);
		
		return model;
		
	}
	
}
