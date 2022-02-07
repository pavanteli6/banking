package com.banking.auth.utilities;

import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.exception.InvalidRequestException;

@Service
public class Validations {

	public void registerCustomer(Customers customer) {

		if(customer.getFirstName().equals("")) {
			throw new InvalidRequestException("First name should not be null!");
		}
		if(customer.getLastName().equals("")) {
			throw new InvalidRequestException("Last name should not be null!");
		}
		if(customer.getMiddletName().equals("")) {
			throw new InvalidRequestException("Middle name should not be null!");
		}
		
		String phoneRegex = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
		if(customer.getMobileNumber().matches(phoneRegex)== false) {
			throw new InvalidRequestException("Mobile number should be in proper format");
		}
		
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(customer.getEmailId().matches(emailRegex)==false) {
			throw new InvalidRequestException("Email id shoul be in proper format ");
		}
		
	}

	public void loginCustomer(Customers customer) {

		if(customer.getPassword().equals("")) {
			throw new InvalidRequestException("password should not be blank ");
		}

		if(customer.getEmailId().equals("")) {
			throw new InvalidRequestException("email id should not be blank ");
		}
		
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(customer.getEmailId().matches(emailRegex)==false) {
			throw new InvalidRequestException("Email id shoul be in proper format ");
		}		
}

	public void addBalanceValidations(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		if(accountDetails.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Account Number Should not be blank ");
		}
		if(accountDetails.getAccountBalance() <= 0) {
			throw new InvalidRequestException("Account Number Should not be less than zero or negative ");
			
		}
		
	}
}
