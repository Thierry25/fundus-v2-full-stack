package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    Account updateAccount(String username, Account account);
    void deleteAccountByUsername(String username);
    List<Account> getAllAccounts();
}
