package service;

import annotation.Autowired;
import model.Account;
import repository.AccountRepository;

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account getAccount(String id) {
        return accountRepository.getAccount(id);
    }
}
