package com.example.customer_service.DTO;

import lombok.Data;

@Data
public class CustomerSearchRequest {
	String customerNumber;
    Long accountId;
    String email;
}
