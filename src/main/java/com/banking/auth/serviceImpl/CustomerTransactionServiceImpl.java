package com.banking.auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.customerTransaction;
import com.banking.auth.repository.CustomerTransactionRepository;
import com.banking.auth.service.CustomerTransactionService;
@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService{

	@Autowired
	CustomerTransactionRepository customerTransactionRepository;
	
	@Override
	public customerTransaction saveTrasactionLog(customerTransaction sendersTransactionLog) {
		// TODO Auto-generated method stub
		return customerTransactionRepository.save(sendersTransactionLog);
	}

}
