package com.example.BankManagement.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.BankManagement.Model.Customer;
import com.example.BankManagement.Service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // Add Customer
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    // Get All Customers
    @GetMapping("/getCustomer")
    public List<Customer> getCustomer() {
        return service.getCustomer();
    }

    // Get Customer By Id
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    // Update Customer
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable String id,
            @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    // Delete Customer
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
        return "Customer Deleted Successfully";
    }
}