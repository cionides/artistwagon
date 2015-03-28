package com.artistwagon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.MarqetaUser;
import com.artistwagon.web.domain.UserBand;
import com.artistwagon.web.service.BandService;
import com.artistwagon.web.service.MarqetaService;

@Controller
public class DashboardController extends BaseController {
	
	@Autowired
	BandService bandService;
	
	@Autowired
	MarqetaService marqetaService;
	
	@RequestMapping(value = {"/bank/dashboard"}, method = RequestMethod.GET)
	public ModelAndView dashboard() {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		
		List<UserBand> userBand = bandService.getUserBandById(bandService.getActiveBand().get(0).getId());
		model.addObject("userBand", userBand);
		
		MarqetaUser user = marqetaService.getActiveUser();
		model.addObject("user", user);
		
		return model;
 
	}
	
}
