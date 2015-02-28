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

import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.Transaction;
import com.artistwagon.web.domain.UserGroup;
import com.artistwagon.web.service.GroupService;
import com.artistwagon.web.service.TransactionService;

@Controller
public class TransactionController extends BaseController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = {"bank/bands/{groupId}/transactions"}, method = RequestMethod.GET)
	public ModelAndView allTransactions(@PathVariable int groupId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/user");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(groupId);
		model.addObject("userGroup", userGroup);
		
		List<Transaction> transactions = transactionService.getTransactionsForUserGroup(groupId);
		
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
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{groupId}/transactions/{transactionId}/split"}, method = RequestMethod.GET)
	public ModelAndView splitTransaction(@PathVariable int groupId, @PathVariable int transactionId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/split");
		
		List<Transaction> transaction = transactionService.getGroupTransactionById(transactionId);
		model.addObject("transaction", transaction);
		
		List<UserGroup> userGroup = groupService.getUserGroupById(groupId);
		model.addObject("userGroup", userGroup);
		
		List<UserGroup> groupMembers = groupService.getGroupMembers(userGroup.get(0).getGroup().getId());
		model.addObject("groupMembers", groupMembers);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}/withdraw"}, method = RequestMethod.GET)
	public ModelAndView viewWithdrawMoney(@PathVariable int userGroupId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/withdraw");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}/withdraw/submit"}, method = RequestMethod.GET)
	public ModelAndView withdrawMoney(@PathVariable int userGroupId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}/add"}, method = RequestMethod.GET)
	public ModelAndView viewAddMoney(@PathVariable int userGroupId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("transactions/add");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
	
	@RequestMapping(value = {"bank/bands/{userGroupId}/add/submit"}, method = RequestMethod.GET)
	public ModelAndView addMoney(@PathVariable int userGroupId) {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("group/snapshot");
		
		List<UserGroup> userGroup = groupService.getUserGroupById(userGroupId);
		model.addObject("userGroup", userGroup);
		
		model.addObject("leftNavGroups", groupService.getCurrentUsersGroups());
		
		return model;
 
	}
}
