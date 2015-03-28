package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Band;
import com.artistwagon.web.domain.UserBand;

public interface BandDao {
	
	public void createBand(UserBand userBand);
	
	public List<UserBand> getCurrentUsersBands(String username);
	
	public List<UserBand> getUserBandById(int id);
	
	public List<UserBand> getBandMembers(int bandId);
	
	public List<UserBand> getActiveBand(String username);
	
}