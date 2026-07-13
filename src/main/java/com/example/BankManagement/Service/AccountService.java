package com.example.BankManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BankManagement.Model.Account;
import com.example.BankManagement.Repository.AccountRepo;

@Service
public class AccountService {

    private final AccountRepo repo;

    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }

    public Account addAccount(Account account) {
        return repo.save(account);
    }

    public List<Account> getAccount() {
        return repo.findAll();
    }

    public Account getAccountById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Account updateAccount(String id, Account account) {

        Account oldAccount = repo.findById(id).orElse(null);

        if (oldAccount != null) {
            oldAccount.setAccountType(account.getAccountType());
            oldAccount.setBranchName(account.getBranchName());
            oldAccount.setBalance(account.getBalance());

            return repo.save(oldAccount);
        }

        return null;
    }

    public void deleteAccount(String id) {
        repo.deleteById(id);
    }
}