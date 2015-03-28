package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Band;
import com.artistwagon.web.domain.UserBand;

public interface BandService {
	
	public void createBand(UserBand userBand);
	 
	public List<UserBand> getCurrentUsersBands();

	public List<UserBand> getUserBandById(int id);
	
	public List<UserBand> getBandMembers(int bandId);
	
	public List<UserBand> getActiveBand();
 
}
