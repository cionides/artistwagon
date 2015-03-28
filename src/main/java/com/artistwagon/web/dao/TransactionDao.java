package com.artistwagon.web.dao;

import java.util.List;

import com.artistwagon.web.domain.Transaction;

public interface TransactionDao {
	
	public List<Transaction> getTransactionsForUserBand(int userBandId);

	public List<Transaction> getBandTransactionById(int transactionId);

}