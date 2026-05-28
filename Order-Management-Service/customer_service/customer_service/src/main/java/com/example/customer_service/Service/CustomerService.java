package com.example.customer_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.DTO.CustomerSearchRequest;
import com.example.customer_service.Entity.Customer;
import com.example.customer_service.Repository.CustomerRepository;
import com.example.customer_service.Validation.Validation;

@Service
public class CustomerService {

	
	private final CustomerRepository customerRepository;
	private final Validation validation;
	
	public CustomerService(CustomerRepository customerRepository,
            Validation validation) {

			this.customerRepository = customerRepository;
			this.validation = validation;
	}
	 public Customer searchCustomer(CustomerSearchRequest request) {

	     // Validation
	     validation.validateSearchRequest(request);
		//Search using account number
		if(request.getAccountNumber()!= null &&
				!request.getAccountNumber().isBlank()) {
			return customerRepository
					.findByAccountNumber(request.getAccountNumber())
					.orElseThrow(()->
						new RuntimeException("Customer not found"));
		}
		// Search using account id
        else if (request.getAccountId() != null) {

            return customerRepository
                    .findByAccountId(request.getAccountId())
                    .orElseThrow(() ->
                            new RuntimeException("Customer not found"));
        }

        // Search using email
        else {

            return customerRepository
                    .findByEmail(request.getEmail())
                    .orElseThrow(() ->
                            new RuntimeException("Customer not found"));
        }
    }
	
}
