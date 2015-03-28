package com.artistwagon.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artistwagon.web.domain.Band;

@Controller
public class TestController {
	
	@RequestMapping("/api/groups/getallgroups")
	public @ResponseBody Band getAllGroups() {
		
		Band group = new Band();
		group.setName("Rohit");
		
		return group;
	}

}
