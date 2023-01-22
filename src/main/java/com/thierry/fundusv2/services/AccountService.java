package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    Account updateAccount(Account account);
    Account deleteAccountByUsername(String username);
    List<Account> getAllAccounts();
}
