package com.learning.customers.services;

import com.learning.customers.dto.CustomerDto;
import com.learning.customers.dto.LoginDto;
import com.learning.customers.models.CustomerEntity;
import com.learning.customers.repositories.CustomerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Cacheable(value = "customers", key = "#id")
    public Optional<CustomerDto> getCustomerById(int id) {
        return customerRepository.findById(id)
                .stream()
                .map(this::convertToDto)
                .findFirst();
    }

    public Optional<LoginDto> getLoginById(int id) {
        return customerRepository.findById(id)
                .stream()
                .map(this::convertLoginToDto)
                .findFirst();
    }

    private CustomerDto convertToDto(CustomerEntity customer) {

        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getUsername(),
                customer.getEmail()
        );
    }

    private LoginDto convertLoginToDto(CustomerEntity customer) {

        return new LoginDto(
                customer.getUsername(),
                customer.getPassword()
        );
    }


}
