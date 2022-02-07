package com.banking.auth.service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;

public interface CustomerService {

	Customers registerCustomer(Customers customer);

	Customers findCustomerByMail(String emailId);

	AccountDetails addAccountDetails(AccountDetails accountDetails);

	Customers fetchAccountDetails(String accountNumber);

	Customers fetchAccountNumber(String accountNumber);

	int updateCustomers(String firstName,String middletName,String lastName,String mobileNumber,String address ,long customerId );

	Customers fetchCustomerId(long customerId);

	int resetPassword(String newPassword, String email);

	Customers fetchCustomerByEmail(String email);
	

	
}
