package com.artistwagon.web.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artistwagon.web.dao.TransactionDao;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.Transaction;


@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsForUserGroup(int userGroupId) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Transaction where userGroupId=:userGroupId")
				.setParameter("userGroupId", userGroupId);
		
		transactions = query.list();
		
		return transactions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getGroupTransactionById(int transactionId) {
		
		List<Transaction> transaction = new ArrayList<Transaction>();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Transaction where id=:transactionId")
				.setParameter("transactionId", transactionId);
		
		transaction = query.list();
		
		return transaction;
	}
	
}
