package com.banking.auth.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.text.DateFormat;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.repository.AccountDetailsRepository;
import com.banking.auth.repository.CustomerRepository;
import com.banking.auth.service.CustomerService;
import com.banking.auth.utilities.AccountNumberGenerator;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	@Override
	public Customers registerCustomer(Customers customer) {
		// TODO Auto-generated method stub
		
		String currentTime = dateFormat.format(new Date());
		
		String accountNumber = accountNumberGenerator.generateAccountNumber()+""+accountNumberGenerator.generateAccountNumber();
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer.setAccountNumber(accountNumber);
		customer.setTransPin(""+accountNumberGenerator.generateAccountNumber());
		customer.setCreatedDate(accountNumber);
		customer.setUpdatedDate(accountNumber);
		customer.setStatus("1");
		
		return customerRepository.save(customer);
	}
	@Override
	public Customers findCustomerByMail(String emailId) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerByEmail(emailId);
	}
	@Override
	public AccountDetails addAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}
	@Override
	public Customers fetchAccountDetails(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customers fetchAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return customerRepository.fetchAccountNumber(accountNumber);
	}
	@Override
	public int updateCustomers(String firstName,String middletName,String lastName,String mobileNumber,String address ,long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomers(firstName,middletName,lastName,mobileNumber,address ,customerId);
	}
	
	@Override
	public Customers fetchCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.fetchCustomerId(customerId);
	}
	@Override
	public int resetPassword(String newPassword, String email) {
		// TODO Auto-generated method stub
		return customerRepository.resetPassword(newPassword,email);
	}
	@Override
	public Customers fetchCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.fetchCustomerByEmail(email);
	}
}
