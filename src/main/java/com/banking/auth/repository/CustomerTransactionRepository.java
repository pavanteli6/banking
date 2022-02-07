package com.banking.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.customerTransaction;
@Repository
public interface CustomerTransactionRepository extends JpaRepository<customerTransaction, Long>{

}
