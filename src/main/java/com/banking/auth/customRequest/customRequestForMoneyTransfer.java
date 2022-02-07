package com.banking.auth.customRequest;

public class customRequestForMoneyTransfer {

	private String accountNumber;
	private String userAccountNumber;
	private long amount;
	private String branchName;
	private String ifsc;
	private String transactionPin;
	private String createdAt;
	private String updatedAt;
	public customRequestForMoneyTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public customRequestForMoneyTransfer(String accountNumber, String userAccountNumber, long amount,
			String branchName, String ifsc, String transactionPin, String createdAt, String updatedAt) {
		super();
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.transactionPin = transactionPin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
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
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "customRequestForMoneyTransfer [accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", branchName=" + branchName + ", ifsc=" + ifsc
				+ ", transactionPin=" + transactionPin + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	

	
}
