package com.artistwagon.web.serviceimpl;


import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.artistwagon.web.domain.MarqetaUser;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.MarqetaService;
import com.artistwagon.web.service.UserService;

@Service("MarqetaService")
public class MarqetaServiceImpl implements MarqetaService {
	
	@Autowired
	UserService userService;
	
	public MarqetaUser getActiveUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByUsername(auth.getName());
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		BasicCredentialsProvider credentialsProvider =  new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("artistwagon", "zdX5Ax8llyPWBmI"));
		httpClient.setCredentialsProvider(credentialsProvider);
		ClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory(httpClient);
		
		RestTemplate restTemplate = new RestTemplate(rf);
		
		MarqetaUser marqetaUser = restTemplate.getForObject("https://swagger.marqeta.com/v3/users/" + user.getToken(), MarqetaUser.class);
		
		return marqetaUser;
	}
	
}
