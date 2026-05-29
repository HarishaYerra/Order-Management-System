package com.example.customer_service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customer_service.DTO.CustomerSearchRequest;
import com.example.customer_service.Entity.Customer;
import com.example.customer_service.Exception.CustomerNotFoundException;
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
		if(request.getCustomerNumber()!= null &&
				!request.getCustomerNumber().isBlank()) {
			return customerRepository
					.findByCustomerNumber(request.getCustomerNumber())
					.orElseThrow(()->
						new CustomerNotFoundException("Customer not found"));
		}
		// Search using account id
        else if (request.getAccountId() != null) {

            return customerRepository
                    .findByAccountId(request.getAccountId())
                    .orElseThrow(() ->
                            new CustomerNotFoundException("Customer not found"));
        }

        // Search using email
        else {

            return customerRepository
                    .findByEmail(request.getEmail())
                    .orElseThrow(() ->
                            new CustomerNotFoundException("Customer not found"));
        }
    }
	 
	 //getCustomerById
	 public Customer getCustomerById(Long customerId) {
		 return customerRepository.findById(customerId)
				 .orElseThrow(()->
						 	new CustomerNotFoundException("Customer not found"));
	 }
	
	 //Get all Customeres
	 public List<Customer> getAllCustomers(){
		 return customerRepository.findAll();
				 
	 }
	 
	 //Update Customer
	 public Customer updateCustomer(Long customerId,
			 Customer updatedCustomer) {
		 Customer customer = customerRepository.findById(customerId)
				 .orElseThrow(()->new RuntimeException("Customer not found"));
		 	customer.setCustomerNumber(updatedCustomer.getCustomerNumber());
		    customer.setAccountId(updatedCustomer.getAccountId());
		    customer.setCustomerName(updatedCustomer.getCustomerName());
		    customer.setEmail(updatedCustomer.getEmail());
		    customer.setMobile(updatedCustomer.getMobile());
		    customer.setAddress(updatedCustomer.getAddress());
		    customer.setStatus(updatedCustomer.getStatus());

		    return customerRepository.save(customer);
	 }
	 
	 //Delete Customer
	 public void deleteCustomer(Long customerId) {
		 Customer customer = customerRepository.findById(customerId)
				 .orElseThrow(()->new CustomerNotFoundException("Customer not found"));
		 customerRepository.delete(customer);
	 }
}
