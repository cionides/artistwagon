package com.artistwagon.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/api/groups/getallgroups")
	public @ResponseBody String getAllGroups() {
		

		
		return null;
	}

}
