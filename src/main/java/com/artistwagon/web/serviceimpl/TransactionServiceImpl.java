package com.artistwagon.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artistwagon.web.dao.TransactionDao;
import com.artistwagon.web.domain.Transaction;
import com.artistwagon.web.service.TransactionService;

@Service("UserTransactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Transactional(readOnly=true)
	public List<Transaction> getTransactionsForUserBand(int userBandId) {
		
		return transactionDao.getTransactionsForUserBand(userBandId);
		
	}
	
	@Transactional(readOnly=true)
	public List<Transaction> getBandTransactionById(int transactionId) {
		
		return transactionDao.getBandTransactionById(transactionId);
		
	}

}
