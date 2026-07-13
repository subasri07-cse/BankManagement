package com.example.BankManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BankManagement.Model.Customer;

public interface CustomerRepo extends MongoRepository<Customer,String>{

}
