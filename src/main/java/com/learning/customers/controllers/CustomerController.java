package com.learning.customers.controllers;

import com.learning.customers.dto.CustomerDto;
import com.learning.customers.dto.LoginDto;
import com.learning.customers.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<CustomerDto> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int id){
        Optional<CustomerDto> customer = customerService.getCustomerById(id);
        if(customer.isPresent()){
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/customers/login/{id}")
    public ResponseEntity<Object> getCustomerLoginById(@PathVariable int id){
        Optional<LoginDto> customer = customerService.getLoginById(id);
        if(customer.isPresent()){
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/login")
    public String login(@RequestBody CustomerDto customerDto){
        return null;
    }
}
