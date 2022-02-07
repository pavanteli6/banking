package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="customerId")
	private Customers customerId;
	
	private String accountNumber;
	private String branchName;
	private String ifsc;
	private long accountBalance;
	private String status;
	private String createdDate;
	private String updatedDate;
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDetails(long id, Customers customerId, String accountNumber, String branchName, String ifsc,
			long accountBalance, String status, String createdDate, String updatedDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customers getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", branchName=" + branchName + ", ifsc=" + ifsc + ", accountBalance=" + accountBalance + ", status="
				+ status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	

}
