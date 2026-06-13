package com.example.accessingdatajpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(
            CustomerRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/customers")
    public Iterable<Customer> allCustomers() {

        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(
            @PathVariable Long id) {

        return repository.findById(id)
                .orElse(null);
    }
}