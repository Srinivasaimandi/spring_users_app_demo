package com.learning.customers.controllers;

import com.learning.customers.dto.CustomerDto;
import com.learning.customers.services.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerGraphQLController {

    private final CustomerService customerService;

    public CustomerGraphQLController(
            CustomerService customerService) {

        this.customerService = customerService;
    }

    @QueryMapping
    public List<CustomerDto> customers() {
        return customerService.getCustomers();
    }

    @QueryMapping
    public Optional<CustomerDto> customer(@Argument int id) {
        return customerService.getCustomerById(id);
    }
}