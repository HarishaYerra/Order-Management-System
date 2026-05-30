package com.example.customer_service.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.DTO.CustomerSearchRequest;
import com.example.customer_service.Entity.Customer;
import com.example.customer_service.Service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/search")
	public Customer searchCustomer(@RequestBody CustomerSearchRequest request) {
		return customerService.searchCustomer(request);
	}
	
	//Get Customer by ID
	@GetMapping("{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	//Get all customer
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	//Update Customer
	@PutMapping("{customerId}")
	public String updateCustomer(@PathVariable Long customerId,
			@RequestBody Customer customer) {
		return "Customer Details updated successfully";
	}
	
	//Delete Customer
	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomer(customerId);
		return "Customer deleted Successfully";
	}
	
}
