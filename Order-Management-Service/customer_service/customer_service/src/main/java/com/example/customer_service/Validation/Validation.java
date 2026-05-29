package com.example.customer_service.Validation;


import org.springframework.stereotype.Component;

import com.example.customer_service.DTO.CustomerSearchRequest;

import jakarta.validation.ValidationException;

@Component
public class Validation {

    public void validateSearchRequest(CustomerSearchRequest request) {

        boolean isAccountNumberEmpty =
                request.getCustomerNumber() == null ||
                request.getCustomerNumber().isBlank();

        boolean isEmailEmpty =
                request.getEmail() == null ||
                request.getEmail().isBlank();

        if (isAccountNumberEmpty &&
            request.getAccountId() == null &&
            isEmailEmpty) {

            throw new ValidationException(
                    "At least one field required"
            );
        }
    }
}