package com.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    private long id;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID")
//    private UserEntity userEntity;
    private float balance;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    List<TransactionEntity> transactions;
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
	public List<TransactionEntity> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", balance=" + balance + ", transactions=" + transactions + "]";
	}
	public AccountEntity(long id, float balance, List<TransactionEntity> transactions) {
		super();
		this.id = id;
		this.balance = balance;
		this.transactions = transactions;
	}
	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
