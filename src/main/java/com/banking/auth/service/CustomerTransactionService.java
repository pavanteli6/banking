package com.banking.auth.service;

import com.banking.auth.entities.customerTransaction;

public interface CustomerTransactionService {

	customerTransaction saveTrasactionLog(customerTransaction sendersTransactionLog);

}
