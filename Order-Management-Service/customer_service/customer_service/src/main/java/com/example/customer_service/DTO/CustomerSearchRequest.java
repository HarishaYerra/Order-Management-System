package com.example.customer_service.DTO;

import lombok.Data;

@Data
public class CustomerSearchRequest {
	String accountNumber;
    Long accountId;
    String email;
}
