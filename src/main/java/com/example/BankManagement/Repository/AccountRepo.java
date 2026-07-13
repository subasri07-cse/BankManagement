package com.example.BankManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BankManagement.Model.Account;

public interface AccountRepo extends MongoRepository<Account,String>{

}