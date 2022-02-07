package com.banking.auth.controller;
import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customRequest.CustomerRequestForResetPassword;
import com.banking.auth.customeresponse.CustomResponseForAccountDetails;
import com.banking.auth.customeresponse.CustomerResponseForCustomerRegister;
import com.banking.auth.customeresponse.CustomerResponseForNoUser;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.service.AccountService;
import com.banking.auth.service.CustomerService;
import com.banking.auth.utilities.AccountNumberGenerator;
//import com.banking.auth.utilities.MailService;
import com.banking.auth.utilities.Validations;

@RestController
@RequestMapping("/customer/auth")
public class CustomerAuthenticationController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Validations validations;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	
	
	@PostMapping("/registerCustomer")
	
	public ResponseEntity<Object> registerCustomer(@RequestBody Customers customer){
		
		validations.registerCustomer(customer);
		
		Customers findCustomer = customerService.findCustomerByMail(customer.getEmailId());
		
		if(findCustomer == null)
		{
			Customers registeredCustomer = customerService.registerCustomer(customer);
			
			AccountDetails accountDetails = new AccountDetails();


			
			accountDetails.setAccountNumber(registeredCustomer.getAccountNumber());
			accountDetails.setBranchName("Pune");
			accountDetails.setCustomerId(registeredCustomer);
			accountDetails.setAccountBalance(0);
			accountDetails.setIfsc("PARK202122");
			accountDetails.setStatus(registeredCustomer.getStatus());
			
			accountDetails.setCreatedDate(registeredCustomer.getCreatedDate());
			accountDetails.setUpdatedDate(registeredCustomer.getUpdatedDate());
			
			customerService.addAccountDetails(accountDetails);
			
			CustomerResponseForCustomerRegister responseStructure = new CustomerResponseForCustomerRegister(new Date(),"customer created successfully","200",customer);
			
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}
		else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"customer already registered with same email ID!","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
			
		}
		}
	@PostMapping("/loginCustomer")
	public ResponseEntity<Object> loginCustomer(@RequestBody Customers customer){
		
		validations.loginCustomer(customer);
		
		Customers findCustomer = customerService.findCustomerByMail(customer.getEmailId());
		
		//Customers findCustomer = customerService.findUserByEmails(cust.getEmailId());
		//log.info(findCustomer.getPassword());
		
		if(findCustomer!= null) {
			if(passwordEncoder.matches(customer.getPassword(),findCustomer.getPassword())==true){
				CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," Login Successfull ","200");
				return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
			}
			else {
				CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," Invalid Credentials ","400");
				return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);			}
			
		}else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," Customer not found ","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}
		
	}
	@PostMapping("/fetchAccountDetails")
	public ResponseEntity<Object> fetchAccountDetails(@RequestBody AccountDetails accountDetails){
		
		AccountDetails accountDetail = accountService.fetchAccountDetails(accountDetails.getAccountNumber());
		if(accountDetail != null) {
			CustomResponseForAccountDetails responseStructure = new CustomResponseForAccountDetails(new Date(),"Account Details fetched successsfully ","200",accountDetail);
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," Account not found ","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customers customer){
		
		Customers custId = customerService.fetchCustomerId(customer.getCustomerId());
		if(custId != null) {
			
			custId.setFirstName(customer.getFirstName());
			custId.setMiddletName(customer.getMiddletName());
			custId.setLastName(customer.getLastName());
			custId.setMobileNumber(customer.getMobileNumber());
			custId.setAddress(customer.getAddress());
			customerService.updateCustomers(customer.getFirstName(),customer.getMiddletName(),customer.getLastName(),customer.getMobileNumber(),customer.getAddress(),customer.getCustomerId());
			
			
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Updation Successful","200");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Customer Id not Found","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
			
		}
	}
	

	@PostMapping("/resetPassword")
	
	public ResponseEntity<Object> resetPassword(@RequestBody CustomerRequestForResetPassword customer){
		
		Customers fetchemail = customerService.fetchCustomerByEmail(customer.getEmail());
		
		if(fetchemail != null) {
			if(customer.getPassword().equals(customer.getNewPassword())){
				if(passwordEncoder.matches(customer.getNewPassword(), fetchemail.getPassword())) {
					return new ResponseEntity<Object> ("old password ",HttpStatus.OK);
				}
				else {
						int n = customerService.resetPassword(customer.getNewPassword(),customer.getEmail());
				}}
			else {
				return new ResponseEntity<Object> (" password does not match",HttpStatus.OK);
			}}
			else {
				return new ResponseEntity<Object> ("Record not found ",HttpStatus.OK);
			}
		return new ResponseEntity<Object> ("Password reset successfully",HttpStatus.OK);
					
	}
	
	
	
	/*
	@PostMapping("/sendOTPOnEmail")
	public ResponseEntity<Object> sendOTPOnEmail(@RequestBody Customers customer){
		Customers findCustomers = customerService.findCustomerByMail(customer.getEmailId());
		
		if(findCustomers!= null) {
			MailService.sendMail(customer.getEmailId() ,accountNumberGenerator.generateTransactionPin());
		
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," OTP sent on mail","200");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date()," Mail Id not found","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}	
	}*/
}
