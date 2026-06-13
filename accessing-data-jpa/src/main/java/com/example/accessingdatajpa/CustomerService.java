package com.example.accessingdatajpa;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(
            CustomerRepository repository) {

        this.repository = repository;
    }

    public Iterable<Customer> getAllCustomers() {

        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    public Customer createCustomer(
            Customer customer) {

        return repository.save(customer);
    }

    public Customer updateCustomer(
            Long id,
            Customer updatedCustomer) {

        Customer customer =
                repository.findById(id)
                        .orElse(null);

        if (customer == null) {
            return null;
        }

        customer.setFirstName(
                updatedCustomer.getFirstName());

        customer.setLastName(
                updatedCustomer.getLastName());

        return repository.save(customer);
    }

    public void deleteCustomer(Long id) {

        repository.deleteById(id);
    }
}