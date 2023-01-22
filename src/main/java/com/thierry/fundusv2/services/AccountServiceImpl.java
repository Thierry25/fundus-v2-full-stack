package com.thierry.fundusv2.services;

import com.thierry.fundusv2.exceptions.UserNotFound;
import com.thierry.fundusv2.models.Account;
import com.thierry.fundusv2.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(() -> new UserNotFound("User Not Found"));
    }

    @Override
    public Account updateAccount(String username, Account updatedAccount) {
        var account = findByUsername(username);
        updatedAccount.setId(account.getId());
        updatedAccount.setUsername(username);
        return accountRepository.save(updatedAccount);
    }

    @Override
    public void deleteAccountByUsername(String username) {
        var account = findByUsername(username);
        accountRepository.delete(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
