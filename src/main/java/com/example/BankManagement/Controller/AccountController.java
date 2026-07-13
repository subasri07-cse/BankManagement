package com.example.BankManagement.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.BankManagement.Model.Account;
import com.example.BankManagement.Service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // Add Account
    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account) {
        return service.addAccount(account);
    }

    // Get All Accounts
    @GetMapping("/getAccount")
    public List<Account> getAccount() {
        return service.getAccount();
    }

    // Get Account By Id
    @GetMapping("/getAccount/{id}")
    public Account getAccountById(@PathVariable String id) {
        return service.getAccountById(id);
    }

    // Update Account
    @PutMapping("/updateAccount/{id}")
    public Account updateAccount(@PathVariable String id,
            @RequestBody Account account) {
        return service.updateAccount(id, account);
    }

    // Delete Account
    @DeleteMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable String id) {
        service.deleteAccount(id);
        return "Account Deleted Successfully";
    }
}