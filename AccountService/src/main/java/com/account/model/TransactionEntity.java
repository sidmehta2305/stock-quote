package com.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TransactionEntity {
    @Id
    @Column
    private String transId;
    @Column
    private float amount;
    @Column
    private Date transDate;
    @Column
    private String status;
    @Column
    private String currency;
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public TransactionEntity(String transId, float amount, Date transDate, String status, String currency) {
		super();
		this.transId = transId;
		this.amount = amount;
		this.transDate = transDate;
		this.status = status;
		this.currency = currency;
	}
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
