package com.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @Column
    private String userId;
    @Column
    private String emailId;
    @Column(name = "userName")
    private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity accountEntity;
	public UserEntity(String userId, String emailId, String userName, AccountEntity accountEntity) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.userName = userName;
		this.accountEntity = accountEntity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}
	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
