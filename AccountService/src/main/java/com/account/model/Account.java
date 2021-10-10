package com.account.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Account {
    private long id;
    private float balance;
    List<Transaction> transactions;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Account(long id, float balance, List<Transaction> transactions) {
		super();
		this.id = id;
		this.balance = balance;
		this.transactions = transactions;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
