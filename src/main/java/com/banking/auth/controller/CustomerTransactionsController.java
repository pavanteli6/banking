package com.banking.auth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customRequest.customRequestForMoneyTransfer;
import com.banking.auth.customeresponse.CustomerResponseForNoUser;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.entities.customerTransaction;
import com.banking.auth.service.AccountService;
import com.banking.auth.service.CustomerService;
import com.banking.auth.service.CustomerTransactionService;
import com.banking.auth.utilities.Validations;

@RestController
@RequestMapping("/customer/transactions")
public class CustomerTransactionsController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	Validations validations;
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerTransactionService customerTransactionService;

	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	@PostMapping("/addBalance")
	public ResponseEntity<Object> addBalance(@RequestBody AccountDetails accountDetails){
		
		validations.addBalanceValidations(accountDetails);
		AccountDetails fetchAccountDetails = accountService.fetchAccountDetails(accountDetails.getAccountNumber());
		if(fetchAccountDetails != null) {
			
			long accountBalance = fetchAccountDetails.getAccountBalance()+accountDetails.getAccountBalance();
			String date = "" +dateFormat.format(new Date());
			
			accountService.updateAccountBalance(accountBalance,date,accountDetails.getAccountNumber());
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Account Balance Updated Successfully","409");

			
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		}else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Invalid Account Number","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
		}
	}
	
	@PostMapping("/transferMoney")
	public ResponseEntity<Object> transferMoney(@RequestBody customRequestForMoneyTransfer moneyTransfer ){
		
		
		AccountDetails fetchAccountDetails = accountService.fetchAccountDetails(moneyTransfer.getAccountNumber());
		AccountDetails fetchReceiversAccount = accountService.fetchAccountDetails(moneyTransfer.getUserAccountNumber());
		Customers fetchAccountNumber = customerService.fetchAccountNumber(moneyTransfer.getAccountNumber());
		
		if(fetchAccountDetails!= null && fetchReceiversAccount != null) {
			if(moneyTransfer.getAmount() >= 0 && moneyTransfer.getAmount() <= fetchAccountDetails.getAccountBalance()) {
				if(fetchReceiversAccount.getBranchName().equals(moneyTransfer.getBranchName())) {
					if(fetchReceiversAccount.getIfsc().equals(moneyTransfer.getIfsc())) {
						if(fetchAccountNumber.getTransPin().equals(moneyTransfer.getTransactionPin())) {
							long sendersAccountBalance = fetchAccountDetails.getAccountBalance() - moneyTransfer.getAmount();
							String date = "" +dateFormat.format(new Date());
							
							int sender =accountService.updateAccountBalance(sendersAccountBalance,date,fetchAccountDetails.getAccountNumber());
							customerTransaction sendersTransactionLog = new customerTransaction();
							sendersTransactionLog.setAccountNumber(fetchAccountDetails.getAccountNumber());
							sendersTransactionLog.setAmount(moneyTransfer.getAmount());
							sendersTransactionLog.setUserAccountNumber(moneyTransfer.getUserAccountNumber());
							sendersTransactionLog.setTransactionStatus("Debit");
							sendersTransactionLog.setCreatedAt(date);
							sendersTransactionLog.setUpdatedAt(date);
							
							customerTransactionService.saveTrasactionLog(sendersTransactionLog);
												
							long receiversAccountBalance = fetchReceiversAccount.getAccountBalance() + moneyTransfer.getAmount();
							accountService.updateAccountBalance(receiversAccountBalance,date,fetchReceiversAccount.getAccountNumber());

							customerTransaction receiversTransactionLog = new customerTransaction();
							receiversTransactionLog.setAccountNumber(fetchReceiversAccount.getAccountNumber());
							receiversTransactionLog.setAmount(moneyTransfer.getAmount());
							receiversTransactionLog.setUserAccountNumber(moneyTransfer.getAccountNumber());
							receiversTransactionLog.setTransactionStatus("Credit");
							receiversTransactionLog.setCreatedAt(date);
							receiversTransactionLog.setUpdatedAt(date);
							customerTransactionService.saveTrasactionLog(receiversTransactionLog);

							
							
							CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Money Transfered Successsfully","200");
							return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
						}
						else {
							CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Invalid Transaction Pin","409");
							return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
						}
						}
					else {
							CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Invalid IFSC","409");
							return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
						}
					}
				else {
						CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Invalid Branch Name","409");
						return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
					}
				}
			else {
					CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Enter Valid Amount you dont have enough amount","409");
					return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
					}
			}
		else {
			CustomerResponseForNoUser responseStructure = new CustomerResponseForNoUser(new Date(),"Enter proper account details user doesn't exist","409");
			return new ResponseEntity<Object> (responseStructure ,HttpStatus.OK);
					}
	}
}
