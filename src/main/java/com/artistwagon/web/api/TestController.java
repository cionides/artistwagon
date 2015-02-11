package com.artistwagon.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artistwagon.web.domain.Group;

@Controller
public class TestController {
	
	@RequestMapping("/api/groups/getallgroups")
	public @ResponseBody Group getAllGroups() {
		
		Group group = new Group();
		group.setName("Rohit");
		
		return group;
	}

}
