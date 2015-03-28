package com.artistwagon.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.artistwagon.web.domain.Band;
import com.artistwagon.web.domain.Transaction;
import com.artistwagon.web.domain.UserBand;
import com.artistwagon.web.service.BandService;
import com.artistwagon.web.service.TransactionService;

@Controller
public class TransactionController extends BaseController {

	@Autowired
	BandService bandService;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = {"bank/bands/{bandId}/transactions"}, method = RequestMethod.GET)
	public ModelAndView allTransactions(@PathVariable int bandId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/all");
		
		List<UserBand> userBand = bandService.getUserBandById(bandId);
		model.addObject("userBand", userBand);
		
		List<Transaction> transactions = transactionService.getTransactionsForUserBand(bandId);
		
		List<Transaction> pendingTransactions = new ArrayList<Transaction>();
		List<Transaction> completeTransactions = new ArrayList<Transaction>();
		
		for(Transaction transaction : transactions) {
			if(transaction.getStatus().equalsIgnoreCase("pending")) {
				pendingTransactions.add(transaction);
			} else {
				completeTransactions.add(transaction);
			}
		}
		model.addObject("transactions", transactions);
		model.addObject("pendingTransactions", pendingTransactions);
		model.addObject("completeTransactions", completeTransactions);
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{bandId}/transactions/{transactionId}/split"}, method = RequestMethod.GET)
	public ModelAndView splitTransaction(@PathVariable int bandId, @PathVariable int transactionId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/split");
		
		List<Transaction> transaction = transactionService.getBandTransactionById(transactionId);
		model.addObject("transaction", transaction);
		
		List<UserBand> userBand = bandService.getUserBandById(bandId);
		model.addObject("userBand", userBand);
		
		List<UserBand> bandMembers = bandService.getBandMembers(userBand.get(0).getBand().getId());
		model.addObject("bandMembers", bandMembers);
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}/withdraw"}, method = RequestMethod.GET)
	public ModelAndView viewWithdrawMoney(@PathVariable int userBandId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/withdraw");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
		model.addObject("userBand", userBand);
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}/withdraw/submit"}, method = RequestMethod.GET)
	public ModelAndView withdrawMoney(@PathVariable int userBandId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
		model.addObject("userBand", userBand);
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}/add"}, method = RequestMethod.GET)
	public ModelAndView viewAddMoney(@PathVariable int userBandId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/add");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
		model.addObject("userBand", userBand);
			
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userBandId}/add/submit"}, method = RequestMethod.GET)
	public ModelAndView addMoney(@PathVariable int userBandId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("band/snapshot");
		
		List<UserBand> userBand = bandService.getUserBandById(userBandId);
		model.addObject("userBand", userBand);
		
		return model;
 
	}
}
