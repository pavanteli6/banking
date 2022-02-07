package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long customerId;
	private String firstName;
	private String middletName;
	private String lastName;
	private String adharNumber;
	private String panNumber;
	private String dateOfBirth;
	private String address;
	private String mobileNumber;
	private String emailId;
	private String password;
	private String accountNumber;
	private String transPin;
	private String status;
	private String createdDate;
	private String updatedDate;
	
	public Customers(long customerId, String firstName, String middletName, String lastName, String adharNumber,
			String panNumber, String dateOfBirth, String address, String mobileNumber, String emailId, String password,
			String accountNumber, String transPin, String status, String createdDate, String updatedDate) {
		super();
		
		this.customerId = customerId;
		this.firstName = firstName;
		this.middletName = middletName;
		this.lastName = lastName;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.accountNumber = accountNumber;
		this.transPin = transPin;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddletName() {
		return middletName;
	}
	public void setMiddletName(String middletName) {
		this.middletName = middletName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransPin() {
		return transPin;
	}
	public void setTransPin(String transPin) {
		this.transPin = transPin;
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
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", middletName=" + middletName
				+ ", lastName=" + lastName + ", adharNumber=" + adharNumber + ", panNumber=" + panNumber
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", password=" + password + ", accountNumber=" + accountNumber + ", transPin="
				+ transPin + ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
