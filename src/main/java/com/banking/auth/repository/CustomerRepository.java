package com.banking.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.Customers;
@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long>{

	@Query("SELECT c FROM Customers c WHERE c.emailId = ?1 ")
	Customers findCustomerByEmail(String emailId);

	@Query("SELECT c FROM Customers c WHERE c.accountNumber = ?1 ")
	Customers fetchAccountNumber(String accountNumber);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customers c SET c.firstName =?1,c.middletName = ?2, c.lastName =?3,c.mobileNumber=?4, c.address=?5 WHERE c.customerId =?6")
	int updateCustomers(String FirstName,String MiddletName,String LastName,String MobileNumber,String Address , long customerId);

	@Query("SELECT c FROM Customers c WHERE c.customerId =?1 ")
	Customers fetchCustomerId(long customerId);

	@Modifying
	@Transactional
	@Query("UPDATE Customers c SET c.password=?1 WHERE c.emailId = ?2")
	int resetPassword(String newPassword, String email);

	@Query("SELECT c FROM Customers c WHERE c.emailId = ?1")
	Customers fetchCustomerByEmail(String email);
}
