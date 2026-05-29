package com.example.customer_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer_service.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//Find customer using account id
	Optional<Customer> findByAccountNumber(String accountNumber);
	
	//Find customer using account number
	Optional<Customer> findByAccountId(Long long1);
	
	//Find customer using email
	Optional<Customer> findByEmail(String email);

}
