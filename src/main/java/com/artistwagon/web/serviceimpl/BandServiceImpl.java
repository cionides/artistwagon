package com.artistwagon.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.BandDao;
import com.artistwagon.web.domain.UserBand;
import com.artistwagon.web.service.BandService;

@Service("bandService")
public class BandServiceImpl implements BandService {
	
	@Autowired
	BandDao bandDao;
	
	@Transactional
	public void createBand(UserBand userGroup) {
		
		bandDao.createBand(userGroup);
		
	}
	
	@Transactional(readOnly=true)
	public List<UserBand> getCurrentUsersBands() {
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
		
		return bandDao.getCurrentUsersBands(username);
	}
	
	@Transactional(readOnly=true)
	public List<UserBand> getUserBandById(int id) {
		
		return bandDao.getUserBandById(id);

	}
	
	@Transactional(readOnly=true)
	public List<UserBand> getBandMembers(int bandId) {
		
		return bandDao.getBandMembers(bandId);
		
	}
	
	@Transactional(readOnly=true)
	public List<UserBand> getActiveBand() {
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
		
		return bandDao.getActiveBand(username);
	}

}