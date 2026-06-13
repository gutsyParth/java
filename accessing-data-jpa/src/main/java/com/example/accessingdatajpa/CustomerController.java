package com.example.accessingdatajpa;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(
            CustomerService customerService) {

        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Iterable<Customer> allCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(
            @PathVariable Long id) {

        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(
            @RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {

        return customerService.updateCustomer(
                id,
                customer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(
            @PathVariable Long id) {

        customerService.deleteCustomer(id);

        return "Customer deleted successfully";
    }
}