package com.java8.approaches;

import java.util.ArrayList;
import java.util.List;

import com.java8.approaches.util.Transaction;
import com.java8.approaches.util.TransactionPredicate;
import com.java8.approaches.util.TransactionPredicateByAmount;
import com.java8.approaches.util.TransactionPredicateByLocation;
import com.java8.approaches.util.TransactionUtils;

public class Approach_2 {

	public static void main(String[] args) {
		List<Transaction> allTransactions = TransactionUtils.getAllTransactions();
		
		List<Transaction> filteredTransactions = 
				filterTransactions(allTransactions, new TransactionPredicateByLocation());
		TransactionUtils.printTransactions(filteredTransactions);

		System.out.println("\n\n");
		
		filteredTransactions = 
				filterTransactions(allTransactions, new TransactionPredicateByAmount());
		TransactionUtils.printTransactions(filteredTransactions);
	}

	public static List<Transaction> filterTransactions(List<Transaction> transactions, TransactionPredicate predicate) {
		List<Transaction> filteredTransactions = new ArrayList<Transaction>();
		for(Transaction transaction: transactions) {
			if (predicate.test(transaction)) {
				filteredTransactions.add(transaction);
			}
		}
		return filteredTransactions;
	}
	
}



