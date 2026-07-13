package com.example.BankManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BankManagement.Model.Customer;
import com.example.BankManagement.Repository.CustomerRepo;

@Service
public class CustomerService {

    private final CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getCustomer() {
        return repo.findAll();
    }

    public Customer getCustomerById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Customer updateCustomer(String id, Customer customer) {

        Customer oldCustomer = repo.findById(id).orElse(null);

        if (oldCustomer != null) {
            oldCustomer.setCustomerName(customer.getCustomerName());
            return repo.save(oldCustomer);
        }

        return null;
    }

    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }
}
