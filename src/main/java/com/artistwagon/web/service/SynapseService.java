package com.artistwagon.web.service;

import com.artistwagon.web.domain.User;

public interface SynapseService {

	public void startUserSession(User user);
	
	public void updateUserProfile(User user);
	
}
