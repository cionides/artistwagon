package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Transaction;

public interface TransactionService {
	
	public List<Transaction> getTransactionsForUserBand(int userBandId);

	public List<Transaction> getBandTransactionById(int transactionId);

}
