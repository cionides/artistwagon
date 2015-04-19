package com.artistwagon.web.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.EventDao;
import com.artistwagon.web.domain.Event;
import com.artistwagon.web.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	EventDao eventDao;
	
	@Transactional
	public void makePayment(Integer eventId) {
		
		Event event = eventDao.getEventById(eventId);
		event.setStatus("Paid");
		
		eventDao.updateEvent(event);
	}
	
}