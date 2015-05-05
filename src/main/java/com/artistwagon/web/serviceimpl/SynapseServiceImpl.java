package com.artistwagon.web.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.artistwagon.constant.SynapseConstant;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.SynapseService;
import com.artistwagon.web.service.UserService;

@Service("SynapseService")
public class SynapseServiceImpl implements SynapseService {
	
	@Autowired
	UserService userService;

	public void startUserSession(User user) {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", SynapseConstant.CLIENT_ID);
		map.add("client_secret", SynapseConstant.CLIENT_SECRET);
		map.add("username", user.getSynapseUsername());
		map.add("password", user.getPassword());
		RestTemplate rest = new RestTemplate();
		
		@SuppressWarnings("unchecked")
		Map<String, String> result = rest.postForObject(SynapseConstant.URL + "/api/v2/user/login", map, Map.class);
		
		user.setSynapseSessionToken(result.get("oauth_consumer_key"));
		
		this.updateUserProfile(user);

	}
	
	public void updateUserProfile(User user) {

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("oauth_consumer_key", user.getSynapseSessionToken());
		RestTemplate rest = new RestTemplate();
		
		@SuppressWarnings("unchecked")
		HashMap<String, HashMap<String, Double>> result = rest.postForObject(SynapseConstant.URL + "/api/v2/user/show", map, HashMap.class);
		
		user.setBalance(result.get("user").get("balance"));
		
		userService.updateUser(user);
		
	}
	
	
	
}
