package com.artistwagon.web.service;

import java.util.List;

import com.artistwagon.web.domain.Transaction;

public interface TransactionService {
	
	public List<Transaction> getTransactionsForUserGroup(int userGroupId);

	public List<Transaction> getGroupTransactionById(int transactionId);

}
